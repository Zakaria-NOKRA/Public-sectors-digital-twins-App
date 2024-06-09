
import easyocr
import cv2
import re
import json
import numpy as np
from json import JSONEncoder
from django.http import request
from django.http import JsonResponse, HttpResponse
from django.views.decorators.csrf import csrf_exempt
from ultralytics import YOLO
from deepface import DeepFace

reader = easyocr.Reader(["en"])

@csrf_exempt
def textExtraction(request):
    if request.method == 'POST' and request.FILES.get('img1'):
        img1 = request.FILES['img1']
        # Save the uploaded image to a temporary location
        with open('temp.jpg', 'wb') as f:
            for chunk in img1.chunks():
                f.write(chunk)
        # Read the saved image using OpenCV
        img = cv2.imread('temp.jpg')
        # Perform object detection or other processing on the image
        # For example, you can use a pre-trained model for object detection
        # Replace this with your actual object detection code
        result = reader.readtext(img)
        res = responseShaping(result)
        return JsonResponse(res)
    return JsonResponse({"error": "No image uploaded"})

def responseShaping(result):
    cin_code = re.compile(r'[A-Z]{1,2}[0-9]+')
    date_code = re.compile(r'[0-9]{2}\.[0-9]{2}\.[0-9]{2}')
    name_code = re.compile(r'[A-Z]{3,}|[A-Z]{2,}\s[A-Z]+')
    
    cins = []
    names = set()  # Using a set to avoid duplicate names
    dates = []
    
    for item in result:
        text = item[1]
        if re.match(cin_code, text):
            cins.append(text)
        if re.match(name_code, text) and text not in names and ("carte" not in text) and ("royaume" not in text) :
            names.add(text)
        if re.match(date_code, text):
            dates.append(text)
    
    return {"cin": cins, "name": list(names), "date": dates}

@csrf_exempt
def cardDetection(request):
    if request.method == 'POST' and request.FILES.get('img1'):
        img1 = request.FILES['img1']
        # Save the uploaded image to a temporary location
        with open('temp.jpg', 'wb') as f:
            for chunk in img1.chunks():
                f.write(chunk)
        # Read the saved image using OpenCV
        img = cv2.imread('temp.jpg')
    
        model = YOLO(r'C:/Users/GF63/OneDrive/Bureau/PFA/ModelDeployment/SavedModel/best.pt')

        results = model.predict(source=img)

        boxes = results[0].boxes.xyxy.cpu().tolist()
        for box in boxes:
            crop_obj = img[int(box[1]):int(box[3]), int(box[0]):int(box[2])]
        
        d = {"results": crop_obj.tolist()}

        return JsonResponse(d)
    
def imageProcessing(img):
    rectKernel = cv2.getStructuringElement(cv2.MORPH_RECT, (25, 7))
    sqKernel = cv2.getStructuringElement(cv2.MORPH_RECT, (21, 21))
    gray = cv2.cvtColor(img,cv2.COLOR_BGR2GRAY)
    gray = cv2.GaussianBlur(gray, (3,3), 0)
    blackhat = cv2.morphologyEx(gray, cv2.MORPH_BLACKHAT,sqKernel)
    grad = cv2.Sobel(blackhat, ddepth=cv2.CV_32F, dx=1, dy=0, ksize=-1)
    grad = np.absolute(grad)
    (minVal, maxVal) = (np.min(grad), np.max(grad))
    grad = (grad - minVal) / (maxVal - minVal)
    grad = (grad * 255).astype("uint8")
    standard = cv2.normalize(grad, None, alpha=0, beta=200, norm_type=cv2.NORM_MINMAX)
    closing = cv2.morphologyEx(standard, cv2.MORPH_CLOSE,rectKernel)
    thresh = cv2.threshold(closing, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_OTSU)[1]
    return thresh

@csrf_exempt
def faceComparaison(request):
    if request.method == 'POST' and request.FILES.get('img1') and request.FILES.get('img2'):
        img1 = request.FILES['img1']
        img2 = request.FILES['img2']
        # Save the uploaded images to a temporary location
        with open('temp1.jpg', 'wb') as f:
            for chunk in img1.chunks():
                f.write(chunk)
        with open('temp2.jpg','wb') as f:
            for chunk in img2.chunks():
                f.write(chunk)
        img1 = cv2.imread('temp1.jpg')
        img2 = cv2.imread('temp2.jpg')
        result = DeepFace.verify(img1,img2)
        if (result['verified'] == True):
            return JsonResponse({"result":"true"})
        else :
            return JsonResponse({"result":"false"})







    
    


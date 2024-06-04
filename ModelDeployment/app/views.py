
import easyocr
import cv2
import re
import json
from json import JSONEncoder
from django.http import request
from django.http import JsonResponse, HttpResponse
from django.views.decorators.csrf import csrf_exempt
from ultralytics import YOLO


reader = easyocr.Reader(["en"])

@csrf_exempt
def objectDetection(request):
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
        print("zzzzzzzzzzzzzzzzzzzzzzzzzzzzz")
        print(result)
        print("zzzzzzzzzzzzzzzzzzzzzzzzzzzzz")
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
        if re.match(name_code, text) and text not in names:
            names.add(text)
        if re.match(date_code, text):
            dates.append(text)
    
    return {"cin": cins, "name": list(names), "date": dates}


class NumpyArrayEncoder(JSONEncoder):
    def default(self, obj):
        if isinstance(obj, numpy.ndarray):
            return obj.tolist()
        return JSONEncoder.default(self, obj)


@csrf_exempt
def carddetection(request):

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
        

        d = {"results": crop_obj}

        encodedNumpyData = json.dumps(d, cls=NumpyArrayEncoder)

        return JsonResponse(encodedNumpyData)




    
    


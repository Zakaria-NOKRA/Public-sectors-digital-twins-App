
import easyocr
from django.http import JsonResponse, HttpResponse

from django.views.decorators.csrf import csrf_exempt


reader = easyocr.Reader(["en"])


@csrf_exempt
def objectDetection(request):
    img1_path = request.POST.get("img1", "")
    result = img1_path.readtext(img1_path)
    res = {"result":result}
    return JsonResponse(res)
    


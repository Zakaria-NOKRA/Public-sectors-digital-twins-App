from django.urls import path
from . import views

urlpatterns = [
    path('detection',views.objectDetection, name='detection'),
    path('prediction', views.carddetection, name='prediction')
]
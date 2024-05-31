from django.urls import path
from . import views

urlpatterns = [
    path('detection',views.objectDetection, name='detection')
]
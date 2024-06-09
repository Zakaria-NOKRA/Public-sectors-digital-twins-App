from django.urls import path
from . import views

urlpatterns = [
    path('extraction',views.textExtraction, name='extraction'),
    path('prediction', views.cardDetection, name='prediction'),
    path('comparaison',views.faceComparaison,name='comparaison')
]
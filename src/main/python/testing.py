
import cv2
import numpy as np
import requests
url = 'https://covers.openlibrary.org/b/isbn/9788126527410-L.jpg'
response = requests.get(url, stream=True)
img = cv2.imdecode(np.asarray(bytearray(response.content)), cv2.IMREAD_COLOR)
cv2.imshow('image',img)
cv2.waitKey(0)
cv2.destroyAllWindows()

# def myMax(list1):
# 	max = list1[0]
# 	for x in list1:
# 		if x > max :
# 			max = x
# 	return max
# list1 = [10, 20, 4, 45, 99]
# res=myMax(list1)
# print("Largest element is:",res )
# index = list1.index(res)
# print(index)"""
# list1 = [10, 20, 4, 45, 99]
# for i in list1:
# 	print(i)
# from pathlib import Path
# import cv2
# import easyocr
# import glob
# import pandas as pd
# from difflib import SequenceMatcher
# import nltk
# nltk.download('stopwords')
# nltk.download('punkt')
# from nltk.corpus import stopwords
# from nltk.tokenize import word_tokenize
# import numpy as np
# import string
# import pymongo
# from pdf2image import convert_from_path
# import re
# from pymongo import MongoClient

# path1 = 'static/test.pdf'
# print("the path is:",path1)
# images=convert_from_path(path1)
# img_number=1
# reader = easyocr.Reader(['en'])
# result2 = []
# for y in range(len(images)):
#     bounds = reader.readtext(np.array(images[y]),decoder='beamsearch',detail=0,paragraph=False)
#     result2+= bounds
# print(result2)
# result2=list(map(lambda x: x.split('.')[0], result2))
# print("After decimal",result2)
# new_items = [item for item in result2 if not item.isdigit()]
# print("the pdf is:",new_items)
# while("" in new_items):
#     new_items.remove("")
# print(new_items)
      
            

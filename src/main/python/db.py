from pathlib import Path
import cv2
import easyocr
import glob
import pandas as pd
from difflib import SequenceMatcher
import nltk
nltk.download('stopwords')
nltk.download('punkt')
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import numpy as np
import string
import pymongo
from pdf2image import convert_from_path
import re
from pymongo import MongoClient

client = MongoClient("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false")
db = client["Smart_Library"]
my_collection=db["BookUpload"]
all_records=my_collection.find()
list_cursor=list(all_records)
Book_index=[]
for i in list_cursor:
   Book_index.append(i['Book Index'])
   #print(list)   
list1=[]
for i in list_cursor:
   list1.append(i['Text String'])
   #print(list1) 
list2=[]
for i in list_cursor:
   list2.append(i['Book ID'])
   #print(list2) 
print("the list2 is:",list2)
#result=list1[1]
#print(result)
#******************
s='chinna'
substring=".pdf"
length = len(list1)

for i in range(len(list1)):
    if ".pdf" in Book_index[i] and s==list1[i]:
        print(list1[i])
        print("the i value is:",i)
        path1 = "C:/Users/admin/Library/src/main/python/static"+'/'+Book_index[i]
        images=convert_from_path('C:/Users/admin/Library/src/main/python/static'+'/'+Book_index[i])
        #images=convert_from_path(path1)
        img_number=1
        reader = easyocr.Reader(['en'])
        result2 = []
        for y in range(len(images)):
            bounds = reader.readtext(np.array(images[y]),decoder='beamsearch',detail=0,paragraph=False)
            result2+= bounds
        print(result2)
        result2=list(map(lambda x: x.split('.')[0], result2))
        print("After decimal",result2)
        new_items = [item for item in result2 if not item.isdigit()]
        print("the pdf is:",new_items)
        while("" in new_items):
            new_items.remove("")
        print(new_items)
        for doc1 in my_collection.find():
            my_collection.update_one({"Book ID":list2[i]},{"$set":{"Text String":new_items}})
            print("the doc1 is:",list2[i])
            
    else:
        if s== list1[i]:
            path1 = "C:/Users/admin/Library/src/main/python/static"+'/'+Book_index[i]
            print("the path is:",path1)
            img_number=1
            reader = easyocr.Reader(['en'])
            df1 = pd.DataFrame()
            for file in glob.glob(path1):
                img=cv2.imread(file,0)
                results=reader.readtext(img,detail=0,paragraph=False)
            print(results)
            def listToString(s):
                str1 = ""
                for ele in s:
                    str1 += ele
                return str1
            results1=listToString(results)
            no_integers = [x for x in results1 if not (x.isdigit() 
                                                    or x[0] == '-' and x[1:].isdigit())]
            print(no_integers)
            def removeWord(s,word):
                return s.replace(word,'')
            results1=removeWord(results1,"UNIT")
            word_list=[]
            x = re.search(';', results1)
            if(x!=None):
                    for j in range(len(results1)):
                        word_list = re.split('[,;:]+',results1)
                #print(results)
                #print("the value of i is:",j)
            print(word_list)
            if(word_list!=[]):
                for doc1 in my_collection.find():
                    #print(doc1)
                    my_collection.update_one({"Book ID":list2[i]},{"$set":{"Text String":word_list}})
            else:
                for doc1 in my_collection.find():
                    #print(doc1)
                    my_collection.update_one({"Book ID":list2[i]},{"$set":{"Text String":no_integers}})


   

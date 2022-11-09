from flask import Flask, render_template, request
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
import string
import numpy as np
import requests
import pymongo
from pymongo import MongoClient
app = Flask(__name__)

@app.route("/")
def hello():
    return render_template('start.html')


@app.route("/logins", methods=['POST'])
def logins():
    #rooms = request.form['Image1']
    distance = request.form['Image']
#*************************path1**********************
    
    path1 = r'C:/Users/admin/Desktop'+'/'+distance
    img_number=1
    reader = easyocr.Reader(['en'])
    df1 = pd.DataFrame()
    for file in glob.glob(path1):
        img=cv2.imread(file,0)
        results=reader.readtext(img,detail=0,paragraph=False)
    #df1 = df1.append(pd.DataFrame({"image":file,'detected_text':results[0]}, index=[0]), ignore_index=True)
    #img_number+=1
    
    #convert the list of strings to a single string
    def listToString(s):
        str1 = ""
        for ele in s:
            str1 += ele
        return str1
    results=listToString(results)
    def separateByComma(s):
        return s.split(",")
    results=separateByComma(results)
    #def separateBySemiColon(s):
        #return s.split(";")
    #results=separateBySemiColon(results)
    """results=listToString(results)
    def removeColonAndSemiColon(s):
        return s.translate(str.maketrans('', '', string.punctuation))
    results=removeColonAndSemiColon(results)
    def removeBrackets(s):
        return s.translate(str.maketrans('', '', '()[]{}'))
    results=listToString(results)
    results=removeBrackets(results)
    results=listToString(results)
    def removeSpecialChars2(s):
        return s.translate(str.maketrans('', '', string.digits))
    results=removeSpecialChars2(results)
    results=listToString(results)
    def removeSpecialChars1(s):
        return s.translate(str.maketrans('', '', '$%&*+/=?^|~'))
    results=removeSpecialChars1(results)
    results=listToString(results)
    #given a string remove stop words using NLTK
    def removeStopWords(s):
        from nltk.corpus import stopwords
        stop_words = set(stopwords.words('english'))
        word_tokens = nltk.word_tokenize(s)
        filtered_sentence = [w for w in word_tokens if not w in stop_words]
        filtered_sentence = []
        for w in word_tokens:
            if w not in stop_words:
                filtered_sentence.append(w)
        return filtered_sentence
    results=removeStopWords(results)"""
#*************************path2**********************************************
    client = MongoClient("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false")
    db = client["Smart_Library"]
    my_collection=db["BookUpload"]
    all_records=my_collection.find()
    list_cursor=list(all_records)
    list_TextString=[]
    for i in list_cursor:
        list_TextString.append(i['Text String'])
    
    list_names=[]
    for i in list_cursor:
        list_names.append(i['Book Name'])
    #print(list)   
    list_author=[]
    for i in list_cursor:
        list_author.append(i['Book Author'])
    #print(list1) 
    list_ISBN=[]
    for i in list_cursor:
        list_ISBN.append(i['Book ISBN'])
#******************end of path2**********************************************
    
    def compareLists(results,list_TextString):
        count = 0
        for j in range(len(results)):
            if results[j] in list_TextString:
                count += 1
        return count/len(results)
    i=0
    list2=[]
    #a="china"
    for i in list_TextString:
        ans=compareLists(results,i)
        list2.append(ans)
    """def myMax(list2):
        max = list2[0]
        for x in list2:
            if x > max :
                max = x
        return max
    res=myMax(list2)
    print("Largest element is:",res )"""
    index = list2.index(ans)
    #print(index)
    return render_template('start.html', prediction_text=f'{ans*100}',prediction_text1=f'{list_names[index]}',prediction_text2=f'{list_author[index]}',prediction_text3=f'{list_ISBN[index]}'"""prediction_text4=f'{list2}'""")
    
    
if __name__ == "__main__":
    app.run(debug=True)

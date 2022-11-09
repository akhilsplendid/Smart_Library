from copy import copy
from flask import Flask, render_template, request
import cv2
import easyocr
import glob
import nltk
nltk.download('stopwords')
nltk.download('punkt')
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import re
import numpy as np
from pymongo import MongoClient
from pdf2image import convert_from_path
#import spacy
import itertools
import pandas as pd


app = Flask(__name__)
@app.route("/")
def hello():
    return render_template('img.html')


@app.route("/logins", methods=['POST'])
def logins(): 
    path = request.form['Image_file']
    client = MongoClient("mongodb://localhost:27017/?readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false")
    db = client["Smart_Library"]
    my_collection=db["BookUpload"]
    all_records=my_collection.find()
    list_cursor=list(all_records)
    list_TextString=[]
    for i in list_cursor:
        list_TextString.append(i['Text String'])
    print("the list strings are:",list_TextString)
        
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
    if(path!=''):
        path1 = r'C:/Users/admin/Desktop'+'/'+path
        reader = easyocr.Reader(['en'], gpu=False)
        df1 = pd.DataFrame()
        for file in glob.glob(path1):
            print(file)
            img=cv2.imread(file,0)
            results=reader.readtext(img,detail=0,paragraph=True)
        test_list = [';', ',','.',':']
        ans=[]
        result=[]
        for i in range(len(results)):
            for ele in test_list:
                if(ele in results[i]):
                    result=re.findall(r'[^,;.:_]+',results[i])
                ans.append(result)
        result = list(itertools.chain.from_iterable(ans))
        #print("the extracted text is :",result)
        list3=[]
        for i in range(len(result)):
            list3.append(result[i].strip())
        list5=[]
        for i in range(len(result)):
            values = " ".join(list3[i].split())
            list5.append(values)
        #*********************************************************#[x.lower() for x in lst1]:#[x.lower() for x in lst2]:
        print("the result is:",list5)
        if(list5!=[]):
            res = list()
            def intersection(lst1,lst2):
                for item in lst1:
                    if item in lst2:
                        res.append(item)
                return res
            copy_list=['']*len(list_TextString)
            v=0
            for i in list_TextString:
                ans1=intersection(list5,i)
                copy_list[v]=ans1.copy()
                v=v+1
                ans1.clear()
######################################################################
            copy_lists = ['']*len(test_list)
            sol=[]
            l=0
            for i in copy_list:
                print("the i is.......",i)
                for j in i:
                    if j not in sol:
                        sol.append(j)
                copy_lists[l]=sol.copy()
                sol.clear()
                l=l+1
                # copy_lists=[]
                # val=[]
                # l=0
                # for i in copy_list:
                #     if i not in val:
                #         val.append(i)
                # copy_lists[l]=val
                # l=l+1
                # val.clear()
####################################################3
            prediction_list=[]
            data=dict()
            for i in range(len(list_names)):
                data["Book_Name"]=list_names[i]
                data["Book_Author"]=list_author[i]
                data["Book_ISBN"]=list_ISBN[i]
                data["Topics"]=copy_lists[i]
                if(copy_list[i]!=[]):
                    prediction_list.append(data.copy())
                    print("the prediction list is:",prediction_list)
                #prediction_list.append(data.copy())
            return render_template('rest.html',prediction_list=prediction_list)
    else:
        pdf_path=request.form['Pdf_file']
        images=convert_from_path('C:/Users/admin/Desktop'+'/'+pdf_path,dpi=300)
         #path1 = r'C:/Users/admin/Desktop'+'/'+path
        img_number=1
        reader = easyocr.Reader(['en']) 
        result = []
        for i in range(len(images)):
            bounds = reader.readtext(np.array(images[i]),decoder='beamsearch',detail=0,paragraph=False)
            result+= bounds
        test_list = [';', ',','.']
        ans=[]
        for i in range(len(result)):
            for ele in test_list:
                if(ele in result[i]):
                    result1=re.findall(r'[^,;._]+',result[i])
            ans.append(result1)
        result1 = list(itertools.chain.from_iterable(ans))
        #print("the extracted text is :",result)
        list3=[]
        for i in range(len(result1)):
            list3.append(result1[i].strip())
        list5=[]
        for i in range(len(result1)):
            values = " ".join(list3[i].split())
            list5.append(values)
        #*********************************************************
        print("the result is:",list5)
        if(list5!=[]):
            res =[]
            def intersection(lst1,lst2):
                for item in lst2:
                    if item in lst1:
                        res.append(item)
                return res
            #list2=[]
            copy_list=['']*len(list_TextString)
            v=0
            for i in list_TextString:
                #print("the i is:",i)
                #ans=compareLists(result,i)
                ans1=intersection(list5,i)
                print("the ans1 is:::::::::::::::::::::::::::::::",ans1)
                copy_list[v]=ans1.copy()
                v=v+1
                ans1.clear()
                print("the compared topics are: ", copy_list) 
            prediction_list=[]
            data=dict()
            for i in range(len(list_names)):
                data["Book_Name"]=list_names[i]
                data["Book_Author"]=list_author[i]
                data["Book_ISBN"]=list_ISBN[i]
                data["Topics"]=copy_list[i]
                if(copy_list[i]!=[]):
                    prediction_list.append(data.copy())
                    print("the prediction list is:",prediction_list)
                #prediction_list.append(data.copy())
            return render_template('rest.html',prediction_list=prediction_list)
if __name__ == "__main__":
    app.run(debug=True)

#removing String decimals in list
#list_TextString=list(map(lambda x: x.split('.')[0], list_TextString))
#print(list_TextString)





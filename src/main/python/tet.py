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
path1 = "C:/Users/admin/Library/src/main/python/static/test.jpeg"
img_number=1
reader = easyocr.Reader(['en'])
df1 = pd.DataFrame()
for file in glob.glob(path1):
    img=cv2.imread(file,0)
    results=reader.readtext(img,detail=0,paragraph=True)
"""def applySpaces(s):
    return ' '.join(s)
results=applySpaces(results)
   
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
results=listToString(results)
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
print(results)
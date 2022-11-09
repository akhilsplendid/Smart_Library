import mysql.connector
from flask import Flask, jsonify, render_template, request
import numpy as np
import pandas as pd
import sklearn
import pymongo
import warnings
warnings.simplefilter(action='ignore', category=FutureWarning)
from sklearn.neighbors import NearestNeighbors
from scipy.sparse import csr_matrix
import csv
import re

app = Flask(__name__)
  
def create_matrix(df):
      
    N = len(df['userId'].unique())
    M = len(df['bookId'].unique())
      
    # Map Ids to indices
    user_mapper = dict(zip(np.unique(df["userId"]), list(range(N))))
    book_mapper = dict(zip(np.unique(df["bookId"]), list(range(M))))
      
    # Map indices to IDs
    user_inv_mapper = dict(zip(list(range(N)), np.unique(df["userId"])))
    book_inv_mapper = dict(zip(list(range(M)), np.unique(df["bookId"])))
      
    user_index = [user_mapper[i] for i in df['userId']]
    book_index = [book_mapper[i] for i in df['bookId']]
  
    X = csr_matrix((df["rating"], (book_index, user_index)), shape=(M, N))
      
    return X, user_mapper, book_mapper, user_inv_mapper, book_inv_mapper

def find_similar_books(book_id, X, book_mapper, book_inv_mapper, k, metric='cosine', show_distance=False):
      
    neighbour_ids = []
      
    book_ind = book_mapper[book_id]
    book_vec = X[book_ind]
    k+=1
    kNN = NearestNeighbors(n_neighbors=k, algorithm="brute", metric=metric)
    kNN.fit(X)
    book_vec = book_vec.reshape(1,-1)
    neighbour = kNN.kneighbors(book_vec, return_distance=show_distance)
    for i in range(0,k):
        n = neighbour.item(i)
        neighbour_ids.append(book_inv_mapper[n])
    neighbour_ids.pop(0)
    return neighbour_ids

@app.route("/result",methods=["POST","GET"])
def result():
    output = request.get_json()
    if len(output.keys())<1:
        return {"Status":"Bad Request"}
    book_name = output['key']
    res = isinstance(book_name, str)
    if (res == 0):
        return {"Error":"Invalid Input"}        
    cal = {}
    mydb = mysql.connector.connect(
        host="localhost",
        user="root",
        password="" )
    i=0
    low_book = book_name.lower()
    rec_arr = low_book.split()
    myExcursor=mydb.cursor()
    exquery="SELECT book_name, author_name, rating, 'match' as type, image FROM library.books_data WHERE book_name = '" + book_name +"' OR author_name = '" + book_name + "'"
    myExcursor.execute(exquery)
    myExresult = myExcursor.fetchall()
    for y in myExresult:
        cal[i]=y
        i=i+1
    mycursor = mydb.cursor()
    query = "SELECT book_name, author_name, rating, 'recommendation' as type, image FROM library.books_data WHERE book_name LIKE '%" + book_name + "%' OR author_name LIKE '%" + book_name + "%' "
    if(len(rec_arr) > 1):
        for z in rec_arr:
            query += " OR book_name LIKE '%" + z + "%'"
    query += "order by  rating desc limit 3"
    mycursor.execute(query)
    myresult = mycursor.fetchall()
    if(len(myresult)<2):
        query = "SELECT book_name, author_name, rating, 'recommendation' as type, image FROM library.books_data order by  rating desc limit 3"
    mycursor.execute(query)
    myresult = mycursor.fetchall()
    for x in myresult:
        cal[i] = x
        i=i+1
    return cal
@app.route("/getRecommendations",methods=["GET"])
def getRecommendations():
    ratings = pd.read_csv(r"C:\Users\admin\AppData\Local\Programs\Microsoft VS Code\ratings.csv")
    ratings.head()
    books = pd.read_csv(r"C:\Users\admin\AppData\Local\Programs\Microsoft VS Code\books_dataset.csv")
    books.head()
    n_ratings = len(ratings)
    n_books = len(ratings['bookId'].unique())
    n_users = len(ratings['userId'].unique())
    user_freq = ratings[['userId', 'bookId']].groupby('userId').count().reset_index()
    user_freq.columns = ['userId', 'n_ratings']
    user_freq.head()
    mean_rating = ratings.groupby('bookId')[['rating']].mean()
    lowest_rated = mean_rating['rating'].idxmin()
    books.loc[books['bookId'] == lowest_rated]
    highest_rated = mean_rating['rating'].idxmax()
    books.loc[books['bookId'] == highest_rated]
    ratings[ratings['bookId']==highest_rated]
    ratings[ratings['bookId']==lowest_rated]
    book_stats = ratings.groupby('bookId')[['rating']].agg(['count', 'mean'])
    book_stats.columns = book_stats.columns.droplevel()
    X, user_mapper, book_mapper, user_inv_mapper, book_inv_mapper = create_matrix(ratings)
    book_titles = dict(zip(books['bookId'], books['book_name']))
    book_rating = dict(zip(books['bookId'], books['ratings']))
    book_image = dict(zip(books['bookId'], books['cover_page']))
    myclient = pymongo.MongoClient("mongodb://localhost:27017/")
    mydb = myclient["books"]
    mycol = mydb["searchHistory"]
    myquery = { "userId": "1" }
    mydoc = mycol.find(myquery)
    num = 0
    for x in mydoc:
        num = int(x["bookId"])
    if num>600:
        num = 22 #hard coded to avoid error
    book_id = num
    similar_ids = find_similar_books(book_id, X,book_mapper, book_inv_mapper, k=9 )
    book_title = book_titles[book_id]
    recommendation_list=[]
    data=dict()
    print(f"Since you searched {book_title}")
    for i in similar_ids:
        data["Book_Name"]=book_titles[i]
        data["Book_Rating"]=book_rating[i]
        data["Book_Image"]=book_image[i]
        print(data["Book_Image"])
        recommendation_list.append(data.copy())
    i=0
    return render_template('recommendations.html',recommendation_list=recommendation_list)
@app.route("/search",methods=["GET"])
def search():
    search_text = request.args.get('text')
    myclient = pymongo.MongoClient("mongodb://localhost:27017/")
    mydb = myclient["books"]
    mycol = mydb["books_table"]
    myInsCol = mydb["searchHistory"]
    rgx = re.compile('.*'+ search_text +'.*', re.IGNORECASE)
    # print(rgx)
    search_list=[]
    data=dict()
    query = { "book_name": rgx}
    # query = { "book_name": "/computer/" }
    mydoc = mycol.find(query).sort("rating",-1).limit(3)
    i=0    
    for document in mydoc:
        data["book_id"] = document["book_id"]
        data["book_name"] = document["book_name"]
        data["author_name"] = document["author_name"]
        data["year_of_pub"] = document["year_of_pub"]
        data["publisher_name"] = document["publisher_name"]
        data["image"] = document["image"]
        data["rating"] = document["rating"]
        search_list.append(data.copy())
        mydict = { "userId": "1", "bookId": document["book_id"] }
        insert_query=""
        if i==0:
            x = myInsCol.insert_one(mydict)
        i=i+1
    # return search_text
    # return jsonify({'search_list': search_list})
    return render_template('search.html',search_list=search_list)

@app.route("/test",methods=["GET"])
def test():
    finalBooks = r"C:\Users\H281000\Desktop\major\Engineering_books_data.csv"
    res = ""
    with open(finalBooks,  encoding="utf8") as csvfile:
        datareader = csv.reader(csvfile)
        for row in datareader:
            res+="db.books_table.insert({\"book_id\":\"" + row[0] + "\",\"book_name\":\"" + row[1] + "\",\"author_name\":\"" + row[2] + "\",\"year_of_pub\":\"" + row[7] + "\",\"publisher_name\":\"" + row[6] + "\",\"image\":\"" + row[3] + "\",\"rating\":\""+ row[11] + "\"}\n)"
    res+=""
    return res
    


if __name__ == '__main__':
    app.run(debug=True,port=2000)
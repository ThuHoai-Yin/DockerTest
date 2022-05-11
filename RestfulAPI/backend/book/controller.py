from flask import Blueprint
from .service import addBook,getBook, getBookByName,updateBook,deleteBook

book=Blueprint("book",__name__)

@book.route("/getBook")
def getAllBook():
    return getBook()

@book.route("/addBook",methods=['POST'])
def addBookAPI():
    return addBook()

@book.route("/getBookByName",methods=['GET'])
def getBookByNameAPI():
    return getBookByName()

@book.route("/updateBook", methods=['PUT'])
def updateBookAPI():
    return updateBook()

@book.route("/deleteBook",methods=['DELETE'])
def deleteBookAPI():
    return deleteBook()
    


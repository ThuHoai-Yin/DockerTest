from queue import Empty
from flask import request
from backend.extension import db
from backend.library_ma import BookSchema
from backend.model import Book
import json

book_schema= BookSchema
books_schema = BookSchema(many=True)

def addBook():
    try:
        name=request.json['name']
        author = request.json['author']
        new_book= Book(name,author)
        db.session.add(new_book)
        db.session.commit()
        return "Add successfully"
    except Exception :
        db.session.rollback()
        
        return "Can not add book"

def getBook():
    books=Book.query.all()
    if books is None:
        return "Empty"
    return books_schema.jsonify(books)

def getBookByName(bookName):
    books=Book.query.filter_by(name=bookName).all()
    if books is Empty:
            return "Not found"
    return books_schema.jsonify(books)

def updateBook():
    try:
        id=request.json['id']
        name = request.json['name']
        author = request.json['author']
        book=Book.query.get(id)
        book.name = name
        book.idAuthor = author
        db.session.commit()
        return "Update successfully"
    except Exception:
        return "Can not update"

def deleteBook():
    try:
        id=request.json['id']
        book=Book.query.get(id)
        db.session.delete(book)
        db.session.commit()
        return "Deleted"
    except:
        return " Can not delete "
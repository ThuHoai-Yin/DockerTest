from flask import Flask,request,Blueprint
from .extension import db,ma
from .book.controller import book
from .model import Book
import os
from flask_cors import CORS

def create_db(app):
    if not os.path.exists("library/library.db"):
        db.create_all(app=app)
        print("Created")
    
def create_app(config_file="config.py"):
    app = Flask(__name__)
    CORS(app)
    db.init_app(app)
    ma.init_app(app)
    app.config.from_pyfile(config_file)
    create_db(app)
    app.register_blueprint(book)
    return app
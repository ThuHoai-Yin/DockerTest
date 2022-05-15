from sys import api_version
from flask import Flask, request, Blueprint
from .extension import db, ma
from .book.controller import book,api
from .model import Book
import os
from flask_cors import CORS
from flask_restx import Resource, Api, fields
from flask_restx.api import Swagger


def create_db(app):
    if not os.path.exists("library/library.db"):
        db.create_all(app=app)
        print("Created")


def create_app(config_file="config.py"):
    app = Flask(__name__)
    api_version = Api( app=app,
    title='My Title',
    version='1.0',
    description='A description',
    # All API metadatas
    )  
    db.init_app(app)
    ma.init_app(app)
    app.config.from_pyfile(config_file)
    create_db(app)
    app.register_blueprint(book)
    api_version.add_namespace(api)
    return app

from attr import validate
from flask import Blueprint
from flask import Flask, request, redirect, jsonify
from werkzeug.datastructures import FileStorage
from werkzeug.utils import secure_filename
import os
from .service import addBook,getBook, getBookByName,updateBook,deleteBook,getFile,uploadFile

import urllib.request
book=Blueprint("book",__name__)

from flask_restx import Namespace, Resource, fields
api = Namespace('Book', description='Test book')
booki = api.model('Book', {
    'id': fields.Integer(Optional= True,description='The book id'),
    'name': fields.String(required=True, description='The book name'),
    'author': fields.String(required=True, description='The book author'),
})

@api.route("/book")
#@api.doc()
class bookapi(Resource):
   
    def get(self):
        return getBook()
    @api.expect(booki,validate=True)
    @api.marshal_with(booki,code=200)
    def  post(self):
        return addBook()
    @api.expect(booki,validate=True)
    @api.marshal_with(booki,code=200)
    def put(self):
        return updateBook()
    @api.expect(booki,validate=True)
    @api.marshal_with(booki,code=200)
    def delete(self):
        return deleteBook()
ALLOWED_EXTENSIONS = set(['txt', 'pdf', 'png', 'jpg', 'jpeg', 'gif'])
upload_parser = api.parser()
upload_parser.add_argument('file', location='files', type=FileStorage)
def allowed_file(filename):
    	return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS 

@api.route('/file-upload')
@api.doc()
class Upload(Resource):
    def get(self):
        return getFile()
    @api.expect(upload_parser)
    def post(self):
        # check if the post request has the file part
        if 'file' not in request.files:
            resp = jsonify({'message' : 'No file part in the request'})
            resp.status_code = 400
            return resp
        file = request.files['file']
        for handle in file: 
            if file.filename == '':
                resp = jsonify({'message' : 'No file selected for uploading'})
                resp.status_code = 400
                return resp
            if file and allowed_file(file.filename):
                filename = secure_filename(file.filename)
                file.save(os.path.join("D:/uploadspython", filename))
                uploadFile("D:/uploadspython" + filename)
                resp = jsonify({'message' : 'File successfully uploaded'})
                resp.status_code = 201
                continue
            else:
                resp = jsonify({'message' : 'Allowed file types are txt, pdf, png, jpg, jpeg, gif'})
                resp.status_code = 400
                return resp
        return "Upload successfully"
    
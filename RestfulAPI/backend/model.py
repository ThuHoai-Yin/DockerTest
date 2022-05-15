from .extension import db
class Book(db.Model):
    id=db.Column(db.Integer,primary_key=True)
    name=db.Column(db.String(500),nullable=False)
    author=db.Column(db.String(500),nullable=False )
    def __init__(self,name,author):
        self.name = name
        self.author=author
        
class File(db.Model):
    id=db.Column(db.Integer,primary_key=True)
    filename=db.Column(db.String(500),nullable=False)
    def __init__(self,filename) :
        self.filename=filename

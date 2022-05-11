from dataclasses import field
from .extension import  ma

class BookSchema(ma.Schema):
    class Meta:
        fields=('id','name','author')
        
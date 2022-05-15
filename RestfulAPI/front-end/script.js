getBookApi="http://127.0.0.1:5000/getBook"
getAuthorApi = "http://127.0.0.1:5000/getAuthor"
addBookApi="http://127.0.0.1:5000/addBook"
updateBookApi="http://127.0.0.1:5000/updateBook"
deleteBookApi="http://127.0.0.1:5000/deleteBook"


function loadBook(){
    titleTable = 
    " <tr> <th>Id</th> <th>Name</th> <th>Author Name</th> </tr> "
    fetch(getBookApi)
    .then(function(response){
        return response.json();
    })
    .then(function(books){
        var htmls = books.map(function(book){
            return `<tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            </tr>
            `
        })
        var html = titleTable + htmls.join('')
        document.getElementById("book-block").innerHTML = html
    })
    .catch(function(error){
        return error;
    })
}

function handleCreateForm(){
    var submit = document.querySelector('input[type="submit"]')
   
   
    submit.onclick = function(){
        var name = document.querySelector('input[name="name"]').value
        var author = document.querySelector('input[name="author"]').value
        if (name && author)
        {
            data = {
                name: name,
                author:author
            }
            console.log(data)
            createBook(data)
        }
        else {
            alert("Invalid value")
        }
        window.location.href="index.html"

    }
}
function createBook(data){
    var options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    fetch(addBookApi, options)
        .then(function(response){
            return response.json()
        })
        .catch(function(error){
            console.log(error)
        })
}
function createBook(data){
    var options = {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    fetch(addBookApi, options)
        .then(function(response){
            return response.json()
        })
        .catch(function(error){
            console.log(error)
        })
}
function updateBook(data){
    var options = {
        method: 'PUT',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    fetch(updateBookApi, options)
        .then(function(response){
            return response.json()
        })
        .catch(function(error){
            console.log(error)
        })
}
function deleteBook(data){
    console.log(data)
    var options = {
        method: 'DELETE',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }
    
    fetch(deleteBookApi, options)
        .then(function(response){
            return response.json()
        })
        .catch(function(error){
            console.log(error)
        })
}

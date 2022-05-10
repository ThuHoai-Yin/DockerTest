<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Add Category</title>
    </head>
    <body>
        <h1>Add Category!</h1>
        <form action="addCategory" method="post">
            <label>Category Name: </label>
            <input type="text" name="categoryName"/><br/>
            <label>Description:</label>
            <input type="text" name="description" /><br/>
            <span class="text-danger">${requestScope.errorMessage}</span>
            <div>
                <button type="submit">Add</button>
            </div>
        </form>
        <a href="listCategory" id="redirect">  
            <button form="redirect" onclick="">Return to Category List</button>
        </a>
    </body>
</html>

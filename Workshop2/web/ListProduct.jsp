<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Product</title>
    </head>
    <body>
    <center>
        <h1>List Of Products!</h1>
        <c:set var="products" value="${requestScope.PRODUCTS}"/>
        <c:if test="${not empty products}">
            <table class="table table-hover">
                <thead>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Unit</th>
                <th scope="col">Category</th>
                <th scope="col">Price</th>
                <th scope="col">Operations</th>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${products}" varStatus="counter">
                        <tr>
                            <td>${item.getId()}</td>
                            <td>${item.getName()}</td>
                            <td>${item.getUnit()}</td>
                            <td>${item.getCatelogyName()}</td>
                            <td>${item.getPrice()}</td>
                            
                            <%-- Sử dụng get method bằng url  --%>
                            <td>
                                <a href="removeProduct?id=${item.getId()}">Remove</a>
                                <a href="editProduct?id=${item.getId()}">Edit</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table> 
        </c:if>    
     
            <div class="btn-group-toggle" data-toggle="buttons">
                <label class="btn btn-secondary active">
                    <a href="addProduct">  
                        <button type="submit">Add Product</button>
                    </a>
                </label>
            </div>
            <div class="btn-group-toggle" data-toggle="buttons">
                <label class="btn btn-secondary active">
                    <a href="listCategory">  
                        <button onclick="">List Category</button>
                    </a>
                </label>
            </div>
        
    </center>
</body>
</html>

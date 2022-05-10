<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Add Product</title>
    </head>
    <body>
        <h1>Add Product!</h1>
        <c:set var="categories" value="${requestScope.CATEGORIES}"/>
        <form action="addProduct" method="post">
            <div>
                <div>
                    <label >Product Name:</label>
                    <input type="text" name="name" value="${requestScope.name}" required/>
                </div>
                <div>
                    <label>Unit:</label>
                    <input type="text" name="unit" value="${requestScope.unit}" required/>
                </div>
                <div>
                    <label >Category:</label>
                    <select name="categoryName" required>
                          <%-- tạo các option chứa category  --%>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.getName()}"<c:if test="${sessionScope.categoryName ==category.getName()}"> selected </c:if>>${category.getName()}</option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label>Price:  <span class="text-danger">${requestScope.errorMessage}</span></label>
                    <input type="text" name="price" value="${requestScope.price}" required/>
                </div>
                <div>
                    <button type="submit">Add</button>
                    <a href="listProduct" id="redirect">  
                        <button form="redirect" onclick="">Return to Product List</button>
                    </a>
                </div>
        </form>
    </body>
</html>

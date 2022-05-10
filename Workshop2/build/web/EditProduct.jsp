<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <title>Edit Product</title>
    </head>
    <body>
        <h1>Edit Product!</h1>
        <c:set var="product" value="${requestScope.PRODUCT}"/>
        <c:set var="categories" value="${requestScope.CATEGORIES}"/>
        <form action="editProduct" method="post">
            <div>
                <div>
                    <label>ID Product:</label>
                    <input type="text" name="id"  value="${product.getId()}" readonly/>     
                </div>
                <div>
                    <label>Product Name:</label>
                    <input type="text" name="name" value="${product.getName()}" required/>
                </div>
                <div>
                    <label>Unit:</label>
                    <input type="text" name="unit" value="${product.getUnit()}" required/>
                </div>
                <div>
                    <label>Category:</label>
                    <select name="categoryName" required>
                           <%-- Tìm category của product đang được edit để chọn --%>
                        <c:forEach var="category" items="${categories}">
                            <option value="${category.getName()}"
                                   <c:if test="${product.getCatelogyName() == category.getName()}">selected</c:if>
                                    >${category.getName()}
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div>
                    <label>Price:  </label>
                    <input type="text" name="price" value="${product.getPrice()}" required/>
                </div>
                <span class="text-danger">${requestScope.errorMessage}</span>
                <div>
                    <button type="submit">Edit</button>
                    <a href="listProduct" id="redirect">  
                        <button form="redirect" onclick="">Return to Product List</button>
                    </a>
                </div>
        </form>
    </body>
</html>

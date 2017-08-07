<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ADMIN</title>

    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <div class="logo pull-left">
        <a href="/"><img src="/images/home/logo.png" alt=""/></a>
    </div>
    <br>
    <hr/>
    <h1>Admin Panel</h1>
    <hr/>

    <h3>Update Product</h3>
    <%--<c:if test="${!empty productEntity} & ${!empty categoryEntityList} & ${!empty brandEntityList}">--%>
        <form:form action="/updateProduct" method="post" commandname="updateProd" role="form" enctype="multipart/form-data">
            <div class="form-group">
                <label for="productId">Id:</label>
                <input type="text" class="form-control" id="productId" name="id" value="${productEntity.id}"/>
            </div>
            <div class="form-group">
                <label for="productName">Name:</label>
                <input type="text" class="form-control" id="productName" name="name" placeholder="${productEntity.name}"/>
            </div>
            <div class="form-group">
                <label for="image">Image:</label>
                <input type="file" class="form-control" id="image" name="prPic" value=" placeholder="${productEntity.productPic}"/>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" placeholder="${productEntity.price}"/>
            </div>
            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" class="form-control" id="quantity" name="quantity" placeholder="${productEntity.quantity}"/>
            </div>
            <div class="form-group">
                <label for="availability">Availability:</label>
                <input type="text" class="form-control" id="availability" name="availability"
                       placeholder="${productEntity.availability}"/>
            </div>
            <div class="form-group">
                <label for="condition">Condition:</label>
                <input type="text" class="form-control" id="condition" name="condition"
                       placeholder="${productEntity.condition}"/>
            </div>
            <div class="form-group">
                <label for="category_id">CategoryId:</label>
                <select class="form-control" id="category_id" name="categoryId">
                    <c:forEach items="${categoryEntityList}" var="category">
                        <option value="${category.id}">${category.id}. ${category.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="brand_id">BrandId:</label>
                <select class="form-control" id="brand_id" name="brandId">
                    <c:forEach items="${brandEntityList}" var="brand">
                        <option value="${brand.id}">${brand.id}. ${brand.name}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-sm btn-success">Update</button>
            </div>
        </form:form>
    <%--</c:if>--%>
    <hr/>
    <div class="form-group pull-right">
        <a href="/admin">
            <button type="submit" class="btn btn-sm btn-success">Return</button>
        </a>
    </div>
</div>


<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
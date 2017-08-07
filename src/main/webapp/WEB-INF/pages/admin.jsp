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
    <h3>Add Category</h3>
    <form:form action="/admin/addCategory" method="post" commandname="categoryName" role="form">
        <div class="form-group">
            <label for="categoryName">Category name:</label>
            <input type="text" class="form-control" id="categoryName" name="name"
                   placeholder="Enter category name:"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Add</button>
        </div>
    </form:form>

    <h3>Delete Category</h3>
    <form:form action="/admin/deleteCategory" method="post" commandname="categoryId" role="form">
        <div class="form-group">
            <label for="categoryId">Category name:</label>
            <select class="form-control" id="categoryId" name="categoryId">
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Delete</button>
        </div>
    </form:form>
    <hr/>

    <h3>Add Brand</h3>
    <form:form action="/admin/addBrand" method="post" commandname="BrandName" role="form">
        <div class="form-group">
            <label for="brandname">Brand name:</label>
            <input type="text" class="form-control" id="brandname" name="name"
                   placeholder="Enter brand name:"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Add</button>
        </div>
    </form:form>

    <h3>Delete Brand</h3>
    <form:form action="/admin/deleteBrand" method="post" commandname="brandId" role="form">
        <div class="form-group">
            <label for="brandId">Brand name:</label>
            <select class="form-control" id="brandId" name="brandId">
                <c:forEach items="${brandList}" var="brand">
                    <option value="${brand.id}">${brand.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Delete</button>
        </div>
    </form:form>
    <hr/>

    <h3>Add Product</h3>
    <form:form action="/admin/addProduct" method="post" commandname="newProduct" role="form"
               enctype="multipart/form-data">
        <div class="form-group">
            <label for="productName">Name:</label>
            <input type="text" class="form-control" id="productName" name="name" placeholder="Enter name:"/>
        </div>
        <div class="form-group">
            <label for="image">ProductPic:</label>
            <input type="file" class="form-control" id="image" name="prPic"/>
        </div>
        <div class="form-group">
            <label for="price">Price:</label>
            <input type="number" class="form-control" id="price" name="price" placeholder="Enter price:"/>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity:</label>
            <input type="number" class="form-control" id="quantity" name="quantity" placeholder="Enter quantity:"/>
        </div>
        <div class="form-group">
            <label for="availability">Availability:</label>
            <input type="text" class="form-control" id="availability" name="availability"
                   placeholder="Enter availability:"/>
        </div>
        <div class="form-group">
            <label for="condition">Condition:</label>
            <input type="text" class="form-control" id="condition" name="condition"
                   placeholder="Enter condition:"/>
        </div>
        <div class="form-group">
            <label for="category_id">Category:</label>
            <select class="form-control" id="category_id" name="categoryId">
                <c:forEach items="${categoryList}" var="category">
                    <option value="${category.id}">${category.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="brand_id">Brand:</label>
            <select class="form-control" id="brand_id" name="brandId">
                <c:forEach items="${brandList}" var="brand">
                    <option value="${brand.id}">${brand.name}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Add</button>
        </div>
    </form:form>

    <h3>Delete Product</h3>
    <form:form action="/admin/deleteProduct" method="post" commandname="productId" role="form">
        <div class="form-group">
            <label for="productId">Product name:</label>
            <select class="form-control" id="productId" name="productId">
                <c:forEach items="${productList}" var="product">
                    <option value="${product.id}">${product.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">Delete</button>
        </div>
    </form:form>

    <h3>Update Product</h3>
    <form:form action="/admin/updateProduct" commandname="updateProd" method="post" role="form">
        <div class="form-group">
            <label for="prodId">Product name:</label>
            <select class="form-control" id="prodId" name="productId">
                <c:forEach items="${productList}" var="product">
                    <option value="${product.id}">${product.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">UpdateProduct</button>
        </div>
    </form:form>
    <hr/>

    <div class="form-group pull-right">
        <a href="/admin/logout">
            <button type="submit" class="btn btn-sm btn-success">Logout</button>
        </a>
    </div>
</div>


<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>

<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
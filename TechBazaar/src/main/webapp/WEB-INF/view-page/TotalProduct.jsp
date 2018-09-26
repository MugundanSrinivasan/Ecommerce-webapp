 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

<form action="<c:url value="addtocart/${product.productid}"/>" method="get">
 
<table class="table" border="1">
<tr>
<td rowspan="9">
<img src="<c:url value="/resources/images/${product.productid}.jpg"/>">
</td>
</tr>
<tr>
<td>Product Id</td>
<td>${product.productid}</td>
</tr>
<tr>
<td>Product Name</td>
<td>${product.productname}</td>
</tr>
<tr>
<td>Product Name</td>
<td>${product.productdesc}</td>
</tr>
<tr>
<td>Product Stock</td>
<td>${product.stock}</td>
</tr>
<tr>
<td>Product Price</td>
<td>${product.price}</td>
</tr>
<tr>
<td>Supplier Id</td>
<td>${product.supplierid}</td>
</tr>
<tr>
<td>Category</td>
<td>${categoryname}</td>
</tr>
<tr>
<td>Quantity</td>
<td>
<select name="quantity" class="form-control btn-block">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>

</select>
</td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="AddToCart" class="btn-btn-info btn-block"/>
</td>
</tr>

</table>
</form>
</div>
</body>
</html>
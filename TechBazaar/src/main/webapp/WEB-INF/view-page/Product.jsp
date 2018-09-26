<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="Header.jsp" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="InsertProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
<table align="center" cellspacing"3">
<tr>
<td>Product Name</td>
<td><form:input path="productname"/></td>
</tr>
<tr>
<td>Product Desc</td>
<td><form:input path="productdesc"/></td>
</tr>
<tr>
<td>Stock</td>
<td><form:input path="stock"/></td>
</tr>
<tr>
<td>Price</td>
<td><form:input path="price"/></td>
</tr>
<tr>
<td>Category</td>
<td><form:select path="categoryid">
<form:option value="0" label="---selectlist----"/>
<form:options items="${categorylist}"/>
</form:select>
</td>
</tr>
<tr>
<td> Supplier</td>
<td><form:input path="supplierid"/></td>
</tr>
<tr>
<td>Product Image</td>
<td><form:input type="file" path="pimage"/></td>
</tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</table>
</form:form>
<table align="center">
<tr bgcolor="pink">
<td>ProductID</td>
<td>ProductName</td>
<td>ProductDesc</td>
<td>Stock</td>
<td>Price</td>
<td>CategoryId</td>
<td>SupplierId</td>
<td>Operation</td>
</tr>
<c:forEach items="${productlist}" var="product">
<tr>
<td>${product.productid}</td>
<td>${product.productname}</td> 
<td>${product.productdesc}</td> 
<td>${product.stock}</td> 
<td>${product.price}</td> 
<td>${product.categoryid}</td> 
<td>${product.supplierid}</td> 
<td><a href="<c:url value='/deleteproduct/${product.productid}'/>">delete</a>
<a href="<c:url value='/editproduct/${product.productid}'/>">edit</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:url value="/updateproduct" var="url"></c:url>
<form:form action="${url}" modelAttribute="product" method="post">
<table>
<form:input path="productid" value="${product.productid}"/>
<tr>
<td>Product Name</td>
<td><form:input path="productname" value="${product.productname}"/></td>
</tr>
<tr>
<td>Product Desc</td>
<td><form:input path="productdesc" value="${product.productdesc}"/></td>
</tr>
<tr>
<td>Stock</td>
<td><form:input path="stock" value="${product.stock}"/></td>
</tr>
<tr>
<td>Price</td>
<td><form:input path="price" value="${product.price}"/></td>
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
<td><form:input path="supplierid" value="${product.supplierid}"/></td>
</tr>
<tr>
<td><input type="submit" value="updateproduct"></td>
</tr>
</table>
</form:form>

</body>
</html>

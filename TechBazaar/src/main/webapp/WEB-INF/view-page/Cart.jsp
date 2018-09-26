<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td>SL #</td>
<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>Total Price</td>
<td>Operation</td>
</tr>
${username}

<c:forEach items="${cartitems}" var="cartitem">
<c:forEach items="${products}" var="prods">
<form action="<c:url value="/updatecartitem/${cartitem.cartid}"/>" >
<tr>
<td></td>
<td>${cartitem.productname}</td>
<td><input type="text" name="quantity"value="${cartitem.quantity}"/></td>
<td>${cartitem.price}</td>
<td>${cartitem.quantity*cartitem.price}</td>
<c:set value="${prods.getProductname()}" scope="session" var="prodname"/><c:set scope="session" value="${cartitem.getProductname()}" var="cartprod"/>
<c:if test="${prodname==cartprod}">
<input type="hidden" name="productid" value="${prods.getProductid()}">
<c:set var="prodid" scope="session" value="${prods.getProductid()}"/>
${prods.getProductid()}
</c:if><c:out value="${id}"/>
<td><input type="submit" value="update" class="btn btn-info"/>
<a href="<c:url value="/deletecartitem/${cartitem.cartid}?id=${prodid}"/>" class="btn btn-danger">delete</a>
</td>
</tr>
</form></c:forEach>
</c:forEach>
<tr bgcolor="orange">
<td colspan="4"> total purchase amount</td>
<td colspan="2">${totalpurchaseamount}</td>
</tr>
<tr bgcolor="lightblue">
<td colspan="3"><a href="<c:url value="/continueshopping"/>" class="btn btn-info">continue shopping</a>
<td colspan="3"><a href="<c:url value="/checkout"/>" class="btn btn-info">checkout</a>
</table>
</body>
</html>
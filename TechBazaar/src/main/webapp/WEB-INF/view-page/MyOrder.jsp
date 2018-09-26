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
<td colspan="6"><center><h3>Your Order</h3></center></td>
</tr>
<tr>
<td>SL #</td>
<td>Product Name</td>
<td>Quantity</td>
<td>Price</td>
<td>Total Price</td>
</tr>
<c:if test="${empty cartitems}">
<tr><td colspan="6"><center>!!!Your Cart is Empty!!!</center></td></tr>
</c:if>
<c:if test="${not empty cartitems}">
<c:forEach items="${cartitems}" var="cartitem">
<form action="<c:url value="/updatecartitem/${cartitem.cartid}"/>" method="get">
<tr>
<td></td>
<td>${cartitem.productname}</td>
<td>${cartitem.quantity}</td>
<td>${cartitem.price}</td>
<td>${cartitem.quantity*cartitem.price}</td>
</tr>
</form>
</c:forEach>
</c:if>
<tr bgcolor="orange">
<td colspan="4">Total Purchase Amount</td>
<td>${totalpurchaseamount}</td>
</tr>
<tr bgcolor="lightblue">
<td colspan="3"><a href="<c:url value="/continueshopping"/>" class="btn-btn-info">Continue Shopping</a></td>
<td colspan="3"><a href="<c:url value="/payment"/>" class="btn-btn-info">Payment</a></td>
</tr>
</table>
</body>
</html> 
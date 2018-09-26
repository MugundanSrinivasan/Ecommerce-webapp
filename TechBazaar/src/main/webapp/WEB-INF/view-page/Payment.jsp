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
<form action="<c:url value="/paymentprocess"/>" method="POST">
<table>
<tr>
<td colspan="2">
<input type="radio" name="paymenttype" value="CC"/>Credit Card
<input type="radio" name="paymenttype" value="COD"/>Cash On Delivery
</td>
</tr>
<tr>
<td>Cart No:</td>
<td><input type="text" name="cardno" required/></td>
</tr>
<tr>
<td>Cvv:</td>
<td><input type="text" name="cvv" required/></td>
</tr>
<tr>
<td>valid upto:</td>
<td><input type="text" name="valid" required/></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="pay"/>
</table>
</form>
</body>
</html>
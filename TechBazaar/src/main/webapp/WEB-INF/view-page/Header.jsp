<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
 <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<c:if test="${!sessionScope.loggedIn}">
<a href="login">login</a>
<a href="register">register</a>
<a href="aboutus">aboutus</a>
<a href="contactus">contactus</a>


</c:if>
<c:if test="${sessionScope.loggedIn}">
<c:if test="${sessionScope.role=='ROLE_ADMIN'}">
<a href="category">category</a>
<a href="product">product</a>
</c:if>
<c:if test="${sessionScope.role=='ROLE_USER'}">
<a href="productdisplay">view products</a>
</c:if>
</c:if>
<c:if test="${sessionScope.loggedIn}">
<font color="white" size="3">Welcome:${username}</font>
<a href="<c:url value="/logout"/>"><font color="white" size="3">LOGOUT</font></a>
</c:if>


</html>  
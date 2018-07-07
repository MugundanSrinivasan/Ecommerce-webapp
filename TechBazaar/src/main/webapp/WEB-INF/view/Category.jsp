<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@include file="Header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="InsertCategory" method="post">
<table>
<tr>
<td>Category Name</td>
<td><input type="text" name="cn"/></td>
</tr>
<tr>
<td>Category Desc</td>
<td><input type="text" name="cd"/></td>
</tr>
<tr>
<td><input type="submit" name="submit"/></td>
</tr>
</table>
</form> 
<table>
<tr>
<td>Category ID</td>
<td>Category NAME</td>
<td>Category Desc</td>
</tr>

 </table>
</body>
</html>
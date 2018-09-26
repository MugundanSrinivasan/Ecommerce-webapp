<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<%@include file="Header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"></head><body>
<form:form action="InsertCategory" modelAttribute="category" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>Category Name</td>
<td><form:input path="categoryname"/></td>
</tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</table>
</form:form>
<table>
<tr>
<td>Category Id</td>
<td>Category Name</td>
<td>Operation</td>
</tr>
<c:forEach items="${categorylist}" var="category">
<tr>
<td>${category.categoryid}</td>
<td>${category.categoryname}</td>
<td><a href="<c:url value='/deletecategory/${category.categoryid}'/>">delete</a>
<a href="<c:url value='/editcategory/${category.categoryid}'/>">edit</a></td> 
</tr>
</c:forEach>
</table>
</body>
</html>
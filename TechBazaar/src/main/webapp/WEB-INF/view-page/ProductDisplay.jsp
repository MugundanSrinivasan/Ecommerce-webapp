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
<link rel="stylesheet" href="<c:url value="resources/css/productdisplay.css"></c:url>">
</head>
<body>
<c:forEach items="${productlist}" var="product">
<div class="container">
<hr>
<div class="card">
<table class="table table-hover shopping-cart-wrap">
<thead class="text-muted">
<tr>
  <th scope="col">Product</th>
  <th scope="col" width="120">Quantity</th>
  <th scope="col" width="120">Price</th>
  <th scope="col" width="200" class="text-right">Option</th>
</tr>
</thead>
<tbody>
<tr>
	<td>
<figure class="media">
	<div class="img-wrap"><img src="<c:url value="resources/images/${product.productid}.jpg"/>" ></div>
	<figcaption class="media-body">
		<h6 class="title text-truncate">${product.productname} </h6>
		<dl class="param param-inline small">
		  <dt>Product Description </dt>
		  <dd>${product.productdesc}</dd>
		</dl>
		</figcaption>
</figure> 
	</td>
	<td> 
		<select class="form-control">
			<option>1</option>
			<option>2</option>	
			<option>3</option>	
			<option>4</option>	
		</select> 
	</td>
	<td> 
		<div class="price-wrap"> 
			<var class="price">Rs.${product.price}</var> 
			</div> 
	</td>
	<td class="text-right"> 
	<a title="" href="" class="btn btn-outline-success" data-toggle="tooltip" data-original-title="Save to Wishlist"> <i class="fa fa-space-shuttle faa-passing animated"></i></a> 
	<a href="<c:url value='/totalproduct/${product.productid}'/>"> View Product</a>
	
	</td>
</tr>

</tbody>
</table>
</div> 

</div> 


<br><br>

</c:forEach>

</body>
</html>
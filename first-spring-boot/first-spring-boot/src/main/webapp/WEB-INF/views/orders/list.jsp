<%@page import="com.valtech.training.firstspringboot.model.OrderModel"%>
<%@page import="java.util.List"%>
<%@page import="com.valtech.training.firstspringboot.entities.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>list of orders</h1>
	<%
	List<OrderModel> orders = (List<OrderModel>) request.getAttribute("orders");
	%>
	<table>
		<tr>
			<th>Id</th>
			<th>Item</th>
			<th>ItemCounter</th>
			<th>Description</th>
			<th>OrderDate</th>
			<th>Actions</th>
		</tr>
		<!-- JSTL core
		
		 <c:forEach> -->
		
		
		
		<%
		for (OrderModel o : orders) {
			request.setAttribute("o", o);
		%>

		<tr>
			<td>${o.id}</td>
			<td>${o.item}</td>
			<td>${o.itemCounter }</td>
			<td>${o.description }</td>
			<td>${o.orderDate }</td>
			<td>   
			  <a href="delete?id=${o.id }">Delete</a>
			<a href="edit?id=${o.id}">Edit</a>
			</td>
		</tr>
		<%
		}
		%>
		<tfoot>
		    <tr>
		    <td colspan="5" align="right"> 
		    <form action="new" method="get">
		    <input type="submit" name="submit" value="New Order">
		    </form>
		    
		    
		      </td>
		    </tr>
		
		</tfoot>
	</table>
</body>
</html>
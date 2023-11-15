<%@page import="com.valtech.training.firstspringboot.model.OrderModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%OrderModel order=(OrderModel)request.getAttribute("order"); %>
	<form  method="post"  action="save?id=<%= order.getId() %>">
		<table>

			<tr>
				<td>Id</td>
				<td><input type="text" disabled="disabled" name="id"  value="<%= order.getId() %>"/></td>
			</tr>
			<tr>
				<td>Item</td>
				<td><input type="text" name="item" value="<%=order.getItem() %>"/></td>
			</tr>
			<tr>
				<td>ItemCounter</td>
				<td><input type="text" name="itemCounter" value="<%= order.getItemCounter()%>"/></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description" value="<%= order.getDescription()%>"/></td>
			</tr>
			<tr>
				<td>OrderDate</td>
				<td><input type="text" name="orderDate" value="<%= order.getOrderDate()%>"/></td>
			</tr>

			<tr>
				<td colspan="2">
				<input type="submit" name="submit"value="Create" />
				 <input type="submit" name="cancel" value="Cancel" />
				</td>

			</tr>

		</table>
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>please login here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="path-to-jquery/jquery.min.js"></script>
<script src="path-to-bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!-- bootstrap/tailwind -->
<form action="mylogin" method="post" >
   <div class="form-group">
Name:<input name="name" type="text" class="form-control"/> <%= request.getAttribute("message") %></div><br/> 
 <div class="form-group"> 
Pass:<input name="pass" type="password" class="form-control"/><%= request.getAttribute("Incorrectpass") %></div><br/>
   <button name="submit" type="submit" class="btn btn-primary">Login</button>
</form>
 <script src="path/to/bootstrap.js"></script>
    <script src="path/to/jquery.js"></script>

</body>
</html>
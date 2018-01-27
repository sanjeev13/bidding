<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ include file="style-head.jsp"%>
<title>User</title>
</head>
<body>
	<h2>Users Information</h2>
	<table class="table table-hover table-bordered"
>
		<tr>
			<td>ID:</td>
			<td>${id}</td>
		</tr>
		<tr>
			<td>Name:</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>Type:</td>
			<td>${type}</td>
		</tr>
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>
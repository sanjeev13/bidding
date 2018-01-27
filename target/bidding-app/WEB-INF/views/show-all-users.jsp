<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ include file="style-head.jsp"%>
</head>
<body>
	<h3>All User's list:</h3>
	<table class="table table-hover table-bordered">
		<tr>
			<td><label>Id</label></td>
			<td><label>Name</label></td>
			<td><label>Type</label></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.type}" /></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>
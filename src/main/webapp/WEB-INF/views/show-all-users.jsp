<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ include file="style-head.jsp"%>
</head>
<body>
	<%@ include file="nav-bar.jsp"%>
	<h3>All User's list:</h3>
	<h4>Click on the row to go to user's bids</h4>
	<table class="table table-hover table-bordered" style="margin: 10px;">
		<tr>
			<td><label>Id</label></td>
			<td><label>Name</label></td>
			<td><label>Type</label></td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr onclick="window.location='/users/${user.id}/bids';">
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.type}" /></td>
			</tr>

		</c:forEach>
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>
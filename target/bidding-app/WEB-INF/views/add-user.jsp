<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ include file="style-head.jsp"%>
</head>
<body>
	<h3>Enter User details</h3>
	<form:form method="POST" action="/users" modelAttribute="user">
		<table class="table table-hover table-bordered" >
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="type">Type</form:label></td>
				<td><form:select path="type" items="${typeList}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td><label>All User's list:</label></td>
			</tr>
			<tr>
				<td><label>Id</label></td>
				<td><label>Name</label></td>
				<td><label>Description</label></td>
			</tr>
			<tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.name}" /></td>
						<td><c:out value="${user.type}" /></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</form:form>
	<%@ include file="footer.jsp"%>
</body>
</html>
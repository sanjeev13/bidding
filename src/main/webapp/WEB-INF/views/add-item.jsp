<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<%@ include file="style-head.jsp"%>
</head>
<body>
	<h3>Welcome, Enter Item details</h3>
	<form:form method="POST" action="/item" modelAttribute="item">
		<table class="table table-hover table-bordered">
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label></td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<%@ include file="footer.jsp"%>
</body>
</html>
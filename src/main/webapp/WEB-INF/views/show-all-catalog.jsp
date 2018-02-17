<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ include file="style-head.jsp"%>
</head>
<body>
	<%@ include file="nav-bar.jsp"%>
	<h3>Catalog list:</h3>
	<h4>Click on the row to go to catalog's bids</h4>
	<table class="table table-hover table-bordered" style="margin: 10px;">
		<tr>
			<td><label>Title</label></td>
			<td><label>Bid Start</label></td>
			<td><label>Bid End</label></td>
			<td><label>Creator</label></td>
			<td><label>Items</label></td>
		</tr>
		<c:forEach items="${catalogs}" var="catalog">
			<tr onclick="window.location='/catalog/${catalog.id}/bids';">
				<td><c:out value="${catalog.title}" /></td>
				<td><c:out value="${catalog.bidStart}" /></td>
				<td><c:out value="${catalog.bidEnd}" /></td>
				<td><c:out value="${catalog.creator}" /></td>
				<td><c:out value="${catalog.items}" /></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>
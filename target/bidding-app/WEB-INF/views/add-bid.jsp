<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" />
<html>
<head>
<%@ include file="style-head.jsp"%>
<title>Bid</title>
</head>
<body>
	<h3>Enter Bid details</h3>
	<form:form method="POST" action="/bid" modelAttribute="bid">
		<table class="table table-hover table-bordered">
			<tr>
				<td><form:label path="catalog">Catalog</form:label></td>
				<td><form:select path="catalog" class="dropdown"
						items="${catalogList}" /></td>
			</tr>
			<tr>
				<td><form:label path="bidder">Bidder</form:label></td>
				<td><form:select path="bidder" class="dropdown"
						items="${userList}" /></td>
			</tr>
			<tr>
				<td><form:label path="amount">Bid amount</form:label></td>
				<td><form:input path="amount" type="number" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="bidTime">Bid Time</form:label></td>
				<td><form:input path="bidTime" type="date" required="true" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			<tr>
				<td><label>All Bids:</label></td>
			</tr>
			<tr>
				<td><label>Id</label></td>
				<td><label>Catalog</label></td>
				<td><label>Bidder</label></td>
				<td><label>Amount</label></td>
				<td><label>Bid time</label></td>
			</tr>
			<tr>
				<c:forEach items="${bids}" var="bid">
					<tr>
						<td><c:out value="${bid.id}" /></td>
						<td><c:out value="${bid.catalog}" /></td>
						<td><c:out value="${bid.bidder}" /></td>
						<td><c:out value="${bid.amount}" /></td>
						<td><c:out value="${bid.bidTime}" /></td>
					</tr>
				</c:forEach>
			</tr>
		</table>
	</form:form>
	<%@ include file="footer.jsp"%>
</body>
</html>
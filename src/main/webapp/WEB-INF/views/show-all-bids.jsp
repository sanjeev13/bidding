<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ include file="style-head.jsp"%>
<title>Bids</title>
<%@ include file="reload.jsp"%>
</head>
<body onload="setInterval(reload, 1000);">
<%@ include file="nav-bar.jsp"%>

	<h3>All Bids:</h3>
	<table class="table table-hover table-bordered" style="margin: 10px;">
		<tr>
			<td><label>Id</label></td>
			<td width="100"><label>Catalog</label></td>
			<td><label>Bidder</label></td>
			<td><label>Amount</label></td>
			<td><label>Bid time</label></td>
		</tr>
		<c:forEach items="${bids}" var="bid">
			<tr>
				<td><c:out value="${bid.id}" /></td>
				<td><c:out value="${bid.catalog}" /></td>
				<td><c:out value="${bid.bidder}" /></td>
				<td><c:out value="${bid.amount}" /></td>
				<td><c:out value="${bid.bidTime}" /></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>
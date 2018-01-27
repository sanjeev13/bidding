<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%@ include file="style-head.jsp"%>
<title>Catalog</title>
<script language="javascript">
	function addRow(tableID) {

		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "chkbox[]";
		cell1.appendChild(element1);

		var cell2 = row.insertCell(1);
		cell2.innerHTML = rowCount + 1;

		var cell3 = row.insertCell(2);
		var element2 = document.createElement("input");
		element2.type = "text";

		var cell4 = row.insertCell(3);
		var element3 = document.createElement("input");
		element3.type = "text";

		var length = (table.rows.length) - 1;
		element2.name = "items[" + length + "].name";
		element3.name = "items[" + length + "].description";

		cell3.appendChild(element2);
		cell4.appendChild(element3);
	}

	function deleteRow(tableID) {
		try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;

			for (var i = 0; i < rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[0].childNodes[0];
				if (null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					rowCount--;
					i--;
				}
			}
		} catch (e) {
			alert(e);
		}
	}
</script>
</head>
<body>
<%@ include file="nav-bar.jsp"%>

	<h3>Enter Catalog details</h3>
	<form:form method="POST" action="/catalog" modelAttribute="catalogForm">
		<table class="table table-hover table-bordered" style="margin: 10px;">
			<tr>
				<td><form:label path="title">Title     </form:label> <form:input
						path="title" type="text" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="bidStart">Bid start </form:label> <form:input
						path="bidStart" type="date" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="bidEnd">Bid end   </form:label> <form:input
						path="bidEnd" type="date" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="creator">Creator   </form:label> <form:select
						path="creator" items="${userList}" /></td>
			</tr>
			<tr>
				<td><label>Add Items</label></td>
			</tr>
			<tr>
				<td><input type="button" value="Add Row"
					onclick="addRow('dataTable')" /> <input type="button"
					value="Delete Row" onclick="deleteRow('dataTable')" /></td>
			</tr>
			<tr>
				<td>
					<table class="table table-hover table-bordered" id="dataTable">
						<tr>
							<td><input type="checkbox" name="chk" /></td>
							<td>1</td>
							<td><input type='text' placeholder="Item name" name="items[0].name" required="true"/></td>
							<td><input type='text' placeholder="Item description" name="items[0].description" required="true"/></td>
						</tr>
					</table>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<table class="table table-hover table-bordered">
		<tr>
			<td><label>Items added:</label></td>
		</tr>
		<tr>
			<td><label>Name</label></td>
			<td><label>Description</label></td>
		</tr>
		<c:forEach items="${catalogForm.items}" var="value">
			<tr>
				<td><c:out value="${value.name}" /></td>
				<td><c:out value="${value.description}" /></td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="footer.jsp"%>
</body>
</html>
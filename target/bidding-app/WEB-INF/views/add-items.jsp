<%-- <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript">
	var rowCount = 1;
	function addMoreRows(form) {
		rowCount++;
		var recRow = '<p id="rowCount'+rowCount+'"><tr><td>
		<input name="" type="text" size="17%"  maxlength="120" />
		</td><td><input name="" type="text"  maxlength="120" style="margin: 4px 5px 0 5px;"/></td>
		<td><input name="" type="text" maxlength="120" style="margin: 4px 10px 0 0px;"/>
		</td></tr> <a href="javascript:void(0);" onclick="removeRow('
				+ rowCount + ');">Delete</a></p>';
		$('#addedRows').append(recRow);
	}

	function removeRow(removeNum) {
		$('#rowCount' + removeNum).remove();
	}
</script>
</head>
<body>
	<form:form action="save" method="POST"
		modelAttribute="DynamicItemsForm">
		<input type="button" onclick="addMoreRows(this.form);" value="AddRow">
		<table rules="all" style="background: #fff;">
			<tr>
				<td style="font-size: 14px;">Name</td>
				<td style="font-size: 14px;">description</td>
			</tr>
			&nbsp;
			<tr id="rowId">
				<td><form:input path="dynamicRow[0].name" type="text" /></td>
				<td><form:input path="dynamicRow[0].description" type="text" /></td>
		</table>
		<div id="addedRows"></div>
		<input type="submit" value="Save">
	</form:form>
</body> --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@page isELIgnored="false"%>
<html>
<head>
<body>
	<h1>Add College Form</h1>
	<H1 style="color: green">${message }</H1>
	<sf:form action="College" method="post" commandName="form">
		<table>

			${success }
			<sf:hidden path="id"></sf:hidden>
			<tr></tr>
			<%-- <tr>
				<td><sf:label path="id">
					Id</sf:label></td>
				</td>
				<td><sf:input path="id" cssClass="form-control"
						placeholder="Id" /></td>
			</tr>
			 --%>
			<tr>
				<td><sf:label path="name">
					Name</sf:label></td>
				</td>
				<td><sf:input path="name" cssClass="form-control"
						placeholder="Name" /></td>
			</tr>
			<tr>
				<td><sf:label path="address">
					Address</sf:label></td>
				<td><sf:input path="address" cssClass="form-control"
						placeholder="Address" /></td>
			</tr>
			<tr>

				<td colspan="2"> <sf:button type="submit" name="operation" value="Save"
						class="btn btn-primary">
						<s:message code="label.save">SAVE</s:message>
					</sf:button></td>


			</tr>


		</table>
	</sf:form>
</body>
</head>
</html>
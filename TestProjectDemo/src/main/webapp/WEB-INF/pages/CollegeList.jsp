<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>

<%@page isELIgnored="false"%>
<html>
<head></head>
<title>College List sssss</title>

<body>
	<sf:form action="search" method="post" commandName="form">

		<c:choose>
			<c:when test="${not empty list }">
				<table>
					<tr>
						<th>id</th>
						<th>name</th>
						<th>adreess</th>
					</tr>
					<c:forEach items="${list }" var="college">

						<tr>

							<td>${college.id}</td>
							<td>${college.name}</td>
							<td>${college.address}</td>
						</tr>
					</c:forEach>

				</table>
			</c:when>
		</c:choose>
	</sf:form>
</body>
</html>
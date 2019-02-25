<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page isELIgnored="false"%>

<HTML>
<HEAD>
</HEAD>
<BODY>
	<H1 style="color: green">${message }</H1>
	<f:form action="Welcome" method="post">
		<input type="submit" value="Send Post Request" name="operation">
	</f:form>
</BODY>
</HTML>
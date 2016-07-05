<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/pages/error.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script src="javascript/validation.js"></script>
	<head>
		<title>Регистрация</title>
	</head>
	<body>
		<form:form name="registrationForm" method="POST" action="/create">

			<spring:message code="page.common.input.data"/><br/>
			<table align="center">
				<tr>
					<td><spring:message code="page.common.input.fio"/></td>
					<td><input type="text" name="fio" value="" size="20"/> <span id="xxx" style="color: yellow;"></span></td>
				</tr>
				<tr>
					<td><spring:message code="page.common.input.passport"/></td>
					<td><input type="text" name="passport" value="" size="20"/><span id="zzz" style="color: green;"></span></td>
				</tr>
				
				<tr>
					<td><spring:message code="page.common.input.login"/></td>
					<td><input type="text" name="login" value="" size="20"/><span id="yyy" style="color: yellow;"></span></td>
				</tr>
				<tr>
					<td><spring:message code="page.common.input.password"/></td>
					<td><input type="password" name="password" value="" size="20"/><span id="www" style="color: yellow;"></span></td>
				<tr>
					<td><spring:message code="page.common.input.repeat"/></td>
					<td><input type="password" name="password2" value="" size="20"/><span id="qqq" style="color: yellow;"></span></td>

				</tr>
					${emptyf}
				</tr>

				</table>

			<input type="submit" class="bu bu1" name="create" value="create" onclick="return valid()"/>
		</form:form>
		<form:form method="GET" action="/">
			<input type="submit" class="bu bu1" value="GoBack" />
		</form:form>

				${operationMessage} 
			${errorUserExsists}
				</form>

		<h2 class="two">CAR RENT</h2>

		<div class="foot">
			<h1>©2016 by Ivan Bolotin</h1>

		</div>

	</body>
</html>
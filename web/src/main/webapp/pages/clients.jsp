<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Клиенты</title>
	</head>
	<body>
		<table border="1">
			<tr bgcolor="#CCCCCC">
					<td align="center"><strong>Фамилия</strong></td>
					<td align="center"><strong>Имя</strong></td>
			</tr>
			<c:forEach var="client" items="${lists}">
				<tr>
					<td><c:out value="${ client.fio }" /></td>
					<td><c:out value="${ client.passport }" /></td>
				</tr>
			</c:forEach>
		</table>
		<form name = "eee" method="POST" action="/gobackadmin">
			<input type="submit" class="bu bu1" name="ee" value="GoBack"/>
		</form>

	</body>
</html>
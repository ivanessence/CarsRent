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
		<form name="registrationForm" method="POST" action="controller">
			
			Введите ваши данные:<br/>
			<table align="center">
				<tr>
					<td>ФИО:</td>
					<td><input type="text" name="fio" value="" size="20" required/></td>
				</tr>
				<tr>
					<td>Пасспорт:</td>
					<td><input type="text" name="passport" value="" size="20" required/></td>
				</tr>
				
				<tr>
					<td>Логин:</td>
					<td><input type="text" name="login" value="" size="20" required/></td>
				</tr>
				<tr>
					<td>Пароль:</td>
					<td><input type="password" name="password" value="" size="20" required/></td>
				<tr>
					<td>Повторите пароль:</td>
					<td><input type="password" name="password2" value="" size="20" required/></td>
					<span id="confirmMessage" class="confirmMessage"></span>
				</tr>
					${emptyf}
				</tr>

				</table>
			<input type="submit" class="bu bu1" name="command" value="create" onclick="return checkPass()"/>
			<a href="controller?command=goindex">НА ГЛАВНУЮ</a>

				${operationMessage} 
			${errorUserExsists}
				</form>

		<h2 class="two">CAR RENT</h2>

		<div class="foot">
			<h1>©2016 by Ivan Bolotin</h1>

		</div>

	</body>
</html>
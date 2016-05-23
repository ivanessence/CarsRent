<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="/jsp/error/error.jsp"%>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<html>
<link href="css/style.css" rel="stylesheet" type="text/css" />
	<head>
		<title>Регистрация</title>
	</head>
	<body>
		<form name="registrationForm" method="POST" action="controller">
			
			Введите ваши данные:<br/>
			<table>
				<tr>
					<td>ФИО:</td>
					<td><input type="text" name="fio" value="" size="20"/></td>
				</tr>
				<tr>
					<td>Пасспорт:</td>
					<td><input type="text" name="passport" value="" size="20" /></td>
				</tr>
				
				<tr>
					<td>Логин:</td>
					<td><input type="text" name="login" value="" size="20"/></td>
				</tr>
				<tr>
					<td>Пароль:</td>
					<td><input type="text" name="password" value="" size="20"/></td>
				</tr>
				<tr>
					<td><input type="submit" name="command" value="create" /></td>
					<td><a href="controller?command=goindex">НА ГЛАВНУЮ</a></td>
				</tr>
				</table>
				${success}	
				${operationMessage} 
			${errorUserExsists}
				</form>
		
		
	</body>
</html>
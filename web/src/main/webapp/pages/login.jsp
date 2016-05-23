<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html><head><title>Login</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<form name = "loginPage" method="POST" action="controller">

<div id="templatemo_menu">
Login:<br/>

<input type="text" name="login" value=""/>
<br/>Password:<br/>
<input type="password" name="password" value=""/>
 <br/>
${errorLoginPassMessage}
 <br/>
${wrongAction}
 <br/>
<input type="submit" name="command" value="login"/>
<input type="submit" name="command" value="registration"/>
<a href="controller?command=registration">Регистрация</a>
</div>
<div id="picture">
Car Rent<br/>
<img src="pictures/holden.jpg" alt="A black, brown, and white dog wearing a kerchief">
</div>
</form><hr/>

Links for guest...<br/>
Debug info - session = ${sessionScope}
</body></html>





</body>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="en">
<head>
 <title>CarRent</title>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->


 <!-- Bootstrap -->
 <link rel="stylesheet" href="css/style.css">


</head>

<body>

<form name = "loginPage" method="POST" action="controller">


Login:<br/>

<input type="text" name="login" value=""/>
<br/>Password:<br/>
<input type="password" name="password" value=""/>
 <br/>
${errorLoginPassMessage}
 <br/>
${wrongAction}
 <br/>

<input type="submit" class="bu bu1" name="command" value="LogIn"/>
 <input type="hidden" class="bu bu1" name="command" value="registration"/>
<input type="submit" class="bu bu1" name="command" value="Sign Up"/>


</form>

<%--Links for guest...<br/>--%>
<%--Debug info - session = ${sessionScope}--%>
</body></html>

<h2 class="two">CAR RENT</h2>

<div class="foot">
 <h1>©2016 by Ivan Bolotin</h1>

</div>


</body>


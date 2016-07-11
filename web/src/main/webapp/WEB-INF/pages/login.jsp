<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<tiles:insertDefinition name="defaultTemplate"/>
<head>
    <title>CarRent</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <spring:url value="/css/style.css" var="mainCss"/>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/style.css">


</head>

<body>


<form:form name="loginPage" method="POST" action="/j_spring_security_check">


    <spring:message code="page.common.input.login"/><br/>

    <input type="text" name="login" value=""/>
    <br/><spring:message code="page.common.input.password"/><br/>
    <input type="password" name="password" value=""/>
    <br/>
    <c:if test="${not empty error}">
        ${error}
    </c:if>
    ${errorLoginPassMessage}
    <br/>
    ${wrongAction}
    <br/>

    <input type="submit" class="bu bu1" name="log" value='<spring:message code="page.login"/>'/>
</form:form>

<form name="reg" method="POST" action="/registration">
    <input type="submit" class="bu bu1" name="reg" value='<spring:message code="page.reg"/>'/>
</form>

<div class="table">
    <table>
        <tr>
            <td> Language : <a href="?locale=ru">Русский</a>|
                <a href="?locale=en">English</a>
            </td>

            Current Locale :
        ${pageContext.response.locale}</table>
    </tr>
</div>


<%--Links for guest...<br/>--%>
<%--Debug info - session = ${sessionScope}--%>
</body>
</html>








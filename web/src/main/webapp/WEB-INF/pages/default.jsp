<html xmlns:jsp="http://java.sun.com/JSP/Page"
      xmlns:c="http://java.sun.com/jsp/jstl/core"
      xmlns:s="http://www.springframework.org/tags"
      xmlns:tiles="http://tiles.apache.org/tags-tiles">
<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 05.07.2016
  Time: 20:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<tiles:insertAttribute name="content"/>
<tiles:insertAttribute name="footer"/>

</body>
</html>

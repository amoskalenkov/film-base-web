<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 21.06.2019
  Time: 0:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
    <tr>
        <td>Имя</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${roles}" var="role" varStatus="status">
        <tr valign="top">
            <td>${role.name}</td>
            <td>Удалить Редактировать</td>
        </tr>
    </c:forEach>
</table><br/>
<form action="${pageContext.servletContext.contextPath}/admin/new" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    Имя <input type="text" name="name" value="${user.login}">
    <input type="submit" align="center" value="Submit"/>
</form>
</body>
</html>
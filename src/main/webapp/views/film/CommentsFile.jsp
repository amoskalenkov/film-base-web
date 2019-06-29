<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 20.06.2019
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/film/view">Показать фильмы</a>
<table border="1">
    <tr>
        <td>Коментарий</td>
        <td>Фильм</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${comments}" var="comment" varStatus="status">
        <tr valign="top">
            <td>${comment.text}</td>
            <td>${comment.film.name}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/comments/delete?id=${comment.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table><br/>
<form action="${pageContext.servletContext.contextPath}/comments/new" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    Имя <input type="text" name="text" value="${user.login}">
    <label for="film">Фильм</label>
    <select id="film" name="id">
    <c:forEach items="${films}" var="film" varStatus="status">
        <option value="${film.id}">${film.name}</option>
    </c:forEach>
    </select>
    <input type="submit" align="center" value="Submit"/>
</form>
</body>
</html>

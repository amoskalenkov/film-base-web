<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 18.05.2019
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<a href="${pageContext.servletContext.contextPath}/views/film/CreateFilm.jsp">Добавить фильм</a>
<table border="1">
    <tr>
        <td>Название</td>
        <td>Оценка</td>
        <td>Действия</td>
    </tr>
    <c:forEach items="${films}" var="film" varStatus="status">
        <tr valign="top">
            <td>${film.name}</td>
            <td>${film.rating}</td>
            <td>
                <a href="${pageContext.servletContext.contextPath}/film/edit?id=${film.id}">Редактировать</a>
                <a href="${pageContext.servletContext.contextPath}/film/delete?id=${film.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.servletContext.contextPath}/comments/view/">Показать коментарии</a>
</body>
</html>

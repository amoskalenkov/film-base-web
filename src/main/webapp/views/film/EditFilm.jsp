<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 18.05.2019
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/film/edit" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="hidden" name="filmId" value="${film.id}">
    <table>
        <tr>
            <td align="right" >Film Name : </td>
            <td>
                <input type="text" name="filmName" value="${film.name}">
            </td>
        </tr>
        <tr>
            <td align="right" >Rating : </td>
            <td>
                <input type="text" name="filmRating" value="${film.rating}">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
        <tr>
            <td>Коментарии</td>
        </tr>
        <c:forEach items="${comments}" var="comment" varStatus="status">
            <tr valign="top">
                <td>${comment.text}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 18.05.2019
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/film/create" method="POST">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <table>
        <tr>
            <td align="right" >Film Name : </td>
            <td>
                <input type="text" name="filmName">
            </td>
        </tr>
        <tr>
            <td align="right" >Rating : </td>
            <td>
                <input type="text" name="filmRating">
            </td>
        </tr>
        <tr>
            <td><input type="submit" align="center" value="Submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>

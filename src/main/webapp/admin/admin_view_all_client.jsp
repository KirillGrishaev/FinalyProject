<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Логин</th>
        <th>Пароль</th>
    </tr>
    <c:forEach var="client" items="${clientList}">
        <tr>
            <td>${client.id}</td>
            <td>${client.surName}</td>
            <td>${client.name}</td>
            <td>${client.login}</td>
            <td>${client.password}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

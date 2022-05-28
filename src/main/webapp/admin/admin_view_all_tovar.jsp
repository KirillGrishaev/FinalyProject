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
        <th>Артикул</th>
        <th>Название</th>
        <th>Тип</th>
        <th>Стоимость</th>
        <th>Вес</th>
        <th>Распространенность</th>
    </tr>
    <c:forEach var="habar" items="${tovarList}">
        <tr>
            <td>${habar.article}</td>
            <td>${habar.name}</td>
            <td>${habar.type}</td>
            <td>${habar.cost}</td>
            <td>${habar.weight}</td>
            <td>${habar.rare}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

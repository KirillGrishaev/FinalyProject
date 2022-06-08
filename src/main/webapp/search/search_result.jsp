<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Барыга</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/img/search_background.jpg" class="background" />
<header>
    <div class="topnav">
        <a href="${pageContext.request.contextPath}/index/index_action.jsp">Проходная</a>
        <a href="/Dark_Valley/clientLogin/catalogViewAll">Весь каталог</a>
        <a class="active" href="${pageContext.request.contextPath}/search/search.jsp">Шнырь-ищейка</a>
        <a href="${pageContext.request.contextPath}/client/basket.jsp">Авоська</a>
        <a href="/Dark_Valley/clientLogin/clientCabinet">Личный кабинет</a>
        <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
    </div>
    <hgroup>
        <h2>Гляди что в продаже есть: <br></h2>
        <table>
            <tr>
                <th><h1>Артикул</h1></th>
                <th><h1>Название</h1></th>
                <th><h1>Тип</h1></th>
                <th><h1>Стоимость</h1></th>
                <th><h1>Вес</h1></th>
                <th><h1>Распространенность</h1></th>
            </tr>
            <c:forEach var="habar" items="${searchList}">
                <tr>
                    <td><h1>${habar.article}</h1></td>
                    <td><h1>${habar.name}</h1></td>
                    <td><h1>${habar.type}</h1></td>
                    <td><h1>${habar.cost}</h1></td>
                    <td><h1>${habar.weight}</h1></td>
                    <td><h1>${habar.rare}</h1></td>
                    <td>
                        <form method="get"  action ="/Dark_Valley/clientLogin/basket" style ="display:inline;">
                            <input type="hidden" id = "tovar_name" name = "tovar_name" value="${habar.name}">
                            <input type="hidden" id = "tovar_type" name = "tovar_type" value="${habar.type}">
                            <input type="hidden" id = "tovar_cost" name = "tovar_cost" value="${habar.cost}">
                            <input type="hidden" id = "tovar_weight" name = "tovar_weight" value="${habar.weight}">
                            <input type="hidden" id = "tovar_rare" name = "tovar_rare" value="${habar.rare}">
                            <input type="submit" value="Добавить в авоську"></form>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <h1><a href="${pageContext.request.contextPath}/client/clientLogin/basket.jsp">Проверить авоську</a></h1>
    </hgroup>
</header>
</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
    <title>Берлога пацана</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_login.css">
</head>
<body>
<img src="${pageContext.request.contextPath}/img/cabinet_background.jpg" class="background" />
<header>
    <div class="topnav">
        <a href="${pageContext.request.contextPath}/index/index_action.jsp">Проходная</a>
        <a href="/Dark_Valley/clientLogin/catalogViewAll">Весь каталог</a>
        <a href="${pageContext.request.contextPath}/search/search.jsp">Шнырь-ищейка</a>
        <a href="${pageContext.request.contextPath}/client/basket.jsp">Авоська</a>
        <a class="active"  href="/Dark_Valley/clientLogin/clientCabinet">Личный кабинет</a>
        <a href="/Dark_Valley/clientLogin/zakazSearch">История покупок</a>
        <a href="${pageContext.request.contextPath}/client/cabinet/client_update.jsp">Изменение учетных данных</a>
        <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
    </div>
    <hgroup>
<img src="${pageContext.request.contextPath}/img/avatar.jpg" alt="Avatar" class="avatar">
<c:forEach var="client" items="${clientCabinet}">
        <h1>ID:${client.id}</h1>
        <h1>Фамилия:${client.surName}</h1>
        <h1>Имя:${client.name}</h1>
        <h1>Погоняло:${client.login}</h1>
        <h1>Лавэ в кармане:${client.money}</h1>
</c:forEach>
        <form method="post" action="/Dark_Valley/clientLogin/clientMoneyUp">
            <h1>
                <label for="client_money_up">Внести на депозит:</label>
                <input type="text" id = "client_money_up" name = "client_money_up"><br><br>
                <input type="submit" value="Занести бабла на депозит."></h1>
        </form>
    </hgroup>
</header>
</body>
</html>

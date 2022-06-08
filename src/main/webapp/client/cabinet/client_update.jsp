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
        <a   href="/Dark_Valley/clientLogin/clientCabinet">Личный кабинет</a>
        <a href="/Dark_Valley/clientLogin/zakazSearch">История покупок</a>
        <a class="active" href="${pageContext.request.contextPath}/client/cabinet/client_update.jsp">Изменение учетных данных</a>
        <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
    </div>
    <hgroup>
        <form method="post" action="/Dark_Valley/clientLogin/clientUpdate">
            <h1>
                <label for="client_surName">Новая фамилия:</label>
                <input type="text" id = "client_surName" name = "client_surName"><br><br>
                <label for="client_name">Новое имя:</label>
                <input type="text" id = "client_name" name = "client_name"><br><br>
                <label for="client_login">Новый логин:</label>
                <input type="text" id = "client_login" name = "client_login"><br><br>
                <label for="client_password">Новый пароль:</label>
                <input type="text" id = "client_password" name = "client_password"><br><br>
                <input type="submit" value="Записать новые данные"></h1>
        </form>
    </hgroup>
</header>
</body>
</html>

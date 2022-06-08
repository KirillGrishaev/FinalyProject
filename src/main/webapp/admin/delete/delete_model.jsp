<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <title>Этот готов. Несите следующего</title>
</head>
<img src="${pageContext.request.contextPath}/img/admin_page_background.jpg" class="background" />
<body>
<header>
    <div class="topnav">
        <a href="${pageContext.request.contextPath}/index/index_action.jsp">Проходная</a>
        <a href="/Dark_Valley/clientLogin/catalogViewAll">Весь каталог</a>
        <a href="${pageContext.request.contextPath}/search/search.jsp">Шнырь-ищейка</a>
        <a href="${pageContext.request.contextPath}/client/basket.jsp">Авоська</a>
        <a href="/Dark_Valley/clientLogin/clientCabinet">Личный кабинет</a>
        <a href="${pageContext.request.contextPath}/admin/admin_insert.jsp">Администрирование: добавить</a>
        <a href="/Dark_Valley/clientLogin/admin/tovarViewAll">Администрирование: все товары</a>
        <a href="/Dark_Valley/clientLogin/admin/clientViewAll">Администрирование: все клиенты</a>
        <a class="active"  href="${pageContext.request.contextPath}/admin/delete/delete_form.jsp">Администрирование: удаление</a>
        <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
    </div>
    <hgroup>
<h1>Записей удалено:${delete}</h1>
    </hgroup>
   </header>
</body>
</html>

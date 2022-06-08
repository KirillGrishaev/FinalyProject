<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
    <title>Список ровных пацанов</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/img/admin_page_background.jpg" class="background" />
<header>
    <div class="topnav">
        <a href="${pageContext.request.contextPath}/index/index_action.jsp">Проходная</a>
        <a href="/Dark_Valley/clientLogin/catalogViewAll">Весь каталог</a>
        <a href="${pageContext.request.contextPath}/search/search.jsp">Шнырь-ищейка</a>
        <a href="${pageContext.request.contextPath}/client/basket.jsp">Авоська</a>
        <a href="/Dark_Valley/clientLogin/clientCabinet">Личный кабинет</a>
        <a href="${pageContext.request.contextPath}/admin/admin_insert.jsp">Администрирование:добавить</a>
        <a href="/Dark_Valley/clientLogin/admin/tovarViewAll">Администрирование: все товары</a>
        <a class="active" href="/Dark_Valley/clientLogin/admin/clientViewAll">Администрирование: все клиенты</a>
        <a href="${pageContext.request.contextPath}/admin/delete/delete_form.jsp">Администрирование: удаление</a>
        <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
    </div>
    <hgroup>
        <h1>Список ровных пацанов:</h1>
<table>
    <tr>
        <th><h1>ID</h1></th>
        <th><h1>Фамилия</h1></th>
        <th><h1>Имя</h1></th>
        <th><h1>Логин</h1></th>
        <th><h1>Пароль</h1></th>
        <th><h1>Лавэ в кармане</h1></th>
    </tr>
    <c:forEach var="client" items="${clientList}">
        <tr>
            <td><h1>${client.id}</h1></td>
            <td><h1>${client.surName}</h1></td>
            <td><h1>${client.name}</h1></td>
            <td><h1>${client.login}</h1></td>
            <td><h1>${client.password}</h1></td>
            <td><h1>${client.money}</h1></td>
        </tr>
    </c:forEach>
</table>
        <h1>Для удаления необходимо заполнить полностью все поля-атрибуты в форме удаления.</h1>
    </hgroup>
</header>
</body>
</html>

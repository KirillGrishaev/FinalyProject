<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <title>Весь хабар:</title>
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
        <a class="active" href="/Dark_Valley/clientLogin/admin/tovarViewAll">Администрирование: все товары</a>
        <a  href="/Dark_Valley/clientLogin/admin/clientViewAll">Администрирование: все клиенты</a>
        <a href="${pageContext.request.contextPath}/admin/delete/delete_form.jsp">Администрирование: удаление</a>
        <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
    </div>
    <hgroup>
        <h1>Список барахла на складе:</h1>
<table>
    <tr>
        <th><h1>Артикул</h1></th>
        <th><h1>Название</h1></th>
        <th><h1>Тип</h1></th>
        <th><h1>Стоимость</h1></th>
        <th><h1>Вес</h1></th>
        <th><h1>Распространенность</h1></th>
    </tr>
    <c:forEach var="habar" items="${tovarList}">
        <tr>
            <td><h1>${habar.article}</h1></td>
            <td><h1>${habar.name}</h1></td>
            <td><h1>${habar.type}</h1></td>
            <td><h1>${habar.cost}</h1></td>
            <td><h1>${habar.weight}</h1></td>
            <td><h1>${habar.rare}</h1></td>
        </tr>
    </c:forEach>
</table>
        <h1>Для удаления необходимо заполнить полностью все поля-атрибуты в форме удаления.</h1>
    </hgroup>
</header>
</body>
</html>

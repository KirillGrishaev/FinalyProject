<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
    <title>Список заказов</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
</head>
<body>
<img src="${pageContext.request.contextPath}/img/cabinet_background.jpg" class="background" />
<header>
    <div class="topnav">
        <a href="${pageContext.request.contextPath}/index/index_action.jsp">Проходная</a>
        <a href="/Dark_Valley/clientLogin/catalogViewAll">Весь каталог</a>
        <a href="${pageContext.request.contextPath}/search/search.jsp">Шнырь-ищейка</a>
        <a href="${pageContext.request.contextPath}/client/basket.jsp">Авоська</a>
        <a  href="/Dark_Valley/clientLogin/clientCabinet">Личный кабинет</a>
        <a class="active"  href="/Dark_Valley/clientLogin/zakazSearch">История покупок</a>
        <a href="${pageContext.request.contextPath}/client/cabinet/client_update.jsp">Изменение учетных данных</a>
        <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
    </div>
    <hgroup>
<table>
    <tr>
        <th><h1>Номер заказа:</h1></th>
    </tr>
    <c:forEach var="num_zakaz" items="${zakazList}">
        <tr>
            <td><h1>${num_zakaz}</h1></td>
                 <td>
                     <form action ="/Dark_Valley/clientLogin/zakazList" style ="display:inline;">
                         <h1><input type="hidden" id = "num_zakaz" name = "num_zakaz" value="${num_zakaz}">
                         <input type="submit" value="Просмотреть состав заказа"></h1>
                     </form>
                 </td>
        </tr>
    </c:forEach>
</table>
    </hgroup>
</header>
</body>
</html>

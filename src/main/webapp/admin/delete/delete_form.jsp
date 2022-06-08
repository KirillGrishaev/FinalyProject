<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <meta charset="UTF-8">
    <title>Расстрельный список</title>
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
    <a href="${pageContext.request.contextPath}/admin/admin_insert.jsp">Администрирование: добавить</a>
    <a href="/Dark_Valley/clientLogin/admin/tovarViewAll">Администрирование: все товары</a>
    <a href="/Dark_Valley/clientLogin/admin/clientViewAll">Администрирование: все клиенты</a>
    <a class="active"  href="${pageContext.request.contextPath}/admin/delete/delete_form.jsp">Администрирование: удаление</a>
    <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
  </div>
  <hgroup>
    <h1>Сегодня мы завалим:</h1>
<form method="post" action="/Dark_Valley/clientLogin/admin/clientDelete">
  <h1>
    <label for="client_ID">Номер учетной карточки:</label>
    <input type="text" id = "client_ID" name = "client_ID"><br><br>
  <input type="submit" value="Замочить"></h1>
</form>

<br><br>
    <h1>Что сегодня исчезнет из продажи:</h1>
<form method="post" action="/Dark_Valley/clientLogin/admin/tovarDelete">

  <h1><label for="tovar_article">Учетная карточка барахла:</label>
    <input type="text" id = "tovar_article" name = "tovar_article"><br><br>
  <input type="submit" value="Убрать с прилавка"></h1>
</form>
  </hgroup>
</header>
</body>
</html>
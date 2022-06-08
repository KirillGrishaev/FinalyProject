<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <title>Найти барахло или фраера</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/img/search_background.jpg" class="background" />
<header>
  <div class="topnav">
    <a href="${pageContext.request.contextPath}/index/index_action.jsp">Проходная</a>
    <a href="/Dark_Valley/clientLogin/catalogViewAll">Весь каталог</a>
    <a class="active"  href="${pageContext.request.contextPath}/search/search.jsp">Шнырь-ищейка</a>
    <a href="${pageContext.request.contextPath}/client/basket.jsp">Авоська</a>
    <a href="/Dark_Valley/clientLogin/clientCabinet">Личный кабинет</a>
    <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
  </div>
  <hgroup>
    <h1>Ну что ты там удумал?</h1>
<form method="get" action="/Dark_Valley/clientLogin/tovarSearch">

  <h1><label for="tovar_name">Название барахла:</label>
  <input type="text" id = "tovar_name" name = "tovar_name"><br><br>

  <label for="tovar_type">Тип:</label>
  <input type="text" id = "tovar_type" name = "tovar_type"><br><br>

  <label for="tovar_cost">Сколько стоит этот хлам?</label>
  <input type="text" id = "tovar_cost" name = "tovar_cost"><br><br>

  <label for="tovar_weight">Вес этой барракуды:</label>
  <input type="text" id = "tovar_weight" name = "tovar_weight"><br><br>

  <label for="tovar_rare">Степень доступности:</label>
  <input type="text" id = "tovar_rare" name = "tovar_rare"><br><br>

  <input type="submit" value="Тащи быстрее!"></h1>
</form>
  </hgroup>
</header>
</body>
</html>
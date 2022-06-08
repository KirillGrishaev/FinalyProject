<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <title>Добавить барахла или нового фраера</title>
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
    <a class="active" href="${pageContext.request.contextPath}/admin/admin_insert.jsp">Администрирование:добавить</a>
    <a href="/Dark_Valley/clientLogin/admin/tovarViewAll">Администрирование: все товары</a>
    <a href="/Dark_Valley/clientLogin/admin/clientViewAll">Администрирование: все клиенты</a>
    <a href="${pageContext.request.contextPath}/admin/delete/delete_form.jsp">Администрирование: удаление</a>
    <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
  </div>
  <hgroup>
<h1>Что добавим?</h1>
<form method="post" action="/Dark_Valley/clientLogin/admin/clientInsert">
  <h1><label for="client_surname">Из чьих этот фраер будет?</label>
  <input type="text" id = "client_surname" name = "client_surname"><br><br>
  <label for="client_name">Звать его как?</label>
  <input type="text" id = "client_name" name = "client_name"><br><br>
  <label for="client_login">Кликуха?</label>
  <input type="text" id = "client_login" name = "client_login"><br><br>
  <label for="client_password">Кодовое слово?</label>
  <input type="text" id = "client_password" name = "client_password"><br><br>
    <label for="client_money">Сколько у него капусты на счету?</label>
    <input type="text" id = "client_money" name = "client_money"><br><br>
  <input type="submit" value="Записать в ровных пацанов"></h1>
</form>

<br><br>

<form method="post" action="/Dark_Valley/clientLogin/admin/tovarInsert">
  <h1>
  <label for="tovar_name">Название барахла:</label>
  <input type="text" id = "tovar_name" name = "tovar_name"><br><br>

  <label for="tovar_type">Тип:</label>
  <input type="text" id = "tovar_type" name = "tovar_type"><br><br>

  <label for="tovar_cost">Сколько хочешь за этот хлам?</label>
  <input type="text" id = "tovar_cost" name = "tovar_cost"><br><br>

  <label for="tovar_weight">Ну-ка взвесь эту барракуду:</label>
  <input type="text" id = "tovar_weight" name = "tovar_weight"><br><br>

  <label for="tovar_rare">Степень доступности:</label>
  <input type="text" id = "tovar_rare" name = "tovar_rare"><br><br>

  <input type="submit" value="Выложить на прилавок"></h1>
</form>
    <h1>Для внесения записи необходимо заполнить все поля</h1>
  </hgroup>
</header>
</body>
</html>
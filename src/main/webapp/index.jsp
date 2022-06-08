<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/table.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navigationPanel.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Тёмная Долина</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style_login.css">
</head>
<body>
<img src="${pageContext.request.contextPath}/img/index.jpg" class="background" />
<header>
    <div class="topnav">
        <a class="active" href="${pageContext.request.contextPath}/index/index_action.jsp">Проходная</a>
        <a href="/Dark_Valley/clientLogin/catalogViewAll">Весь каталог</a>
        <a href="${pageContext.request.contextPath}/search/search.jsp">Шнырь-ищейка</a>
        <a href="${pageContext.request.contextPath}/client/basket.jsp">Авоська</a>
        <a href="/Dark_Valley/clientLogin/clientCabinet">Личный кабинет</a>
        <a href="${pageContext.request.contextPath}/admin/admin_insert.jsp">Администрирование</a>
        <a href="${pageContext.request.contextPath}/client/login/logOut.jsp">Выйти с барахолки</a>
    </div>
    <hgroup>
        <h2>Оба-на! Кто к нам колеса катит?! <br></h2>
        <h1> Мы с мутными фраерами дел имеем! Представься:</h1>
        <button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Представиться</button>
        <h1> Сейчас в продаже:</h1>
        <table class="table">
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
    </hgroup>
</header>


<div id="id01" class="modal">

    <form class="modal-content animate" action="/Dark_Valley/clientLoginAll">
        <div class="imgcontainer">
            <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">×</span>
            <img src="${pageContext.request.contextPath}/img/avatar.jpg" alt="Avatar" class="avatar">
        </div>
        <div class="container">
            <label for="username"><b>Погоняло:</b></label>
            <input type="text" id = "username" placeholder="LOGIN" name="username" required>

            <label for="password"><b>Кодовое слово:</b></label>
            <input type="password" id = "password" placeholder="PASSWORD" name="password" required>

            <button type="submit">Представиться</button>
        </div>
    </form>
</div>

<script>
    // Get the modal
    var modal = document.getElementById('id01');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }

</script>

</body>
</html>
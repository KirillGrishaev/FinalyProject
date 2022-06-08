<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"  import = "java.util.*" %>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
  <meta http-equiv="Content-Type" content="text/html; charset = UTF-8">
  <title>Успешное добавление</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/img/admin_page_background.jpg" class="background" />
<header>
  <hgroup>
    <h2>Запись внесена успешно.</h2>
    <h1><a href="${pageContext.request.contextPath}/admin/admin_insert.jsp"> Продолжить</a></h1>
  </hgroup>
</header>
</body>
</html>


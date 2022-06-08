<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0, post-check=0, pre-check=0");
  response.setHeader("Pragma", "no-cache");
%>
<%
  try {
    if ((session.getAttribute("username")).toString() == null || (session.getAttribute("password")).toString() == null) {
      response.sendRedirect("/index/index_action.jsp");
    }
  } catch (Exception e) {
    response.sendRedirect("/index/index_action.jsp");
  }
%>
<html>
<head>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/error.css">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>Проходи, не задерживайся!</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/img/success.jpg" class="background" />
<header>
  <hgroup>
    <h2>Так ты из наших? <br>
    Проходи не задерживайся</h2>
    <h1><a href="/Dark_Valley/clientLogin/clientCabinet"> *Вперед.*</a></h1>
  </hgroup>
</header>
</body>
</html>
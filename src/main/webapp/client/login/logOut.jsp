<%
    session.invalidate();
    request.getServletContext().getRequestDispatcher("/index/index_action.jsp").forward(request,response);
%>
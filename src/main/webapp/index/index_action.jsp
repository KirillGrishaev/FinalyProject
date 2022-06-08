<%@ page import="java.sql.Connection" %>
<%@ page import="ru.shop.helper.Connector" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.shop.requestResult.tovar.TovarRequestViewAll" %>
<%@ page import="java.sql.SQLException" %>
<%
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            ArrayList tovarList = TovarRequestViewAll.getRequest(st);
            request.setAttribute("tovarList", tovarList);
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        } catch (SQLException | ServletException e) {
            response.sendRedirect("/client/login/error.jsp");
            throw new RuntimeException(e);
        }
%>

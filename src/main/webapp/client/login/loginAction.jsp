<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");
    String client_login = (String) request.getAttribute("client_login");
    String client_password = (String) request.getAttribute("client_password");
    try{
        if ((user.equals(client_login)) && (pass.equals(client_password))) {
            session.setAttribute("username", user);
            session.setAttribute("password", pass);
            response.sendRedirect("success.jsp");
        } else {
            request.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(request,response);
        }
    } catch (Exception e) {
        request.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(request,response);
    }
%>

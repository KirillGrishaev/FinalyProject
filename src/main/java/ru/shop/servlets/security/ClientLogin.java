package ru.shop.servlets.security;

import ru.shop.helper.Connector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/clientLoginAll")
public class ClientLogin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = Connector.getConn();
        HttpSession session = request.getSession();
        try{Statement st = connection.createStatement();
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            ResultSet rs = st.executeQuery("SELECT LOGIN, PASSWORD, ROLE FROM client WHERE LOGIN ="+"\""+user+"\""+"AND PASSWORD ="+"\""+pass+"\""+";");
            if (rs.next() == true) {
                int client_role = rs.getInt("ROLE");
                String client_login = rs.getNString("LOGIN");
                String client_password = rs.getNString("PASSWORD");
                session.setAttribute("role", client_role);
                request.setAttribute("client_login", client_login);
                request.setAttribute("client_password", client_password);
                getServletContext().getRequestDispatcher("/client/login/loginAction.jsp").forward(request, response);
            }else {
                String client_login = null;
                String client_password = null;
                request.setAttribute("client_login", client_login);
                request.setAttribute("client_password", client_password);
                getServletContext().getRequestDispatcher("/client/login/loginAction.jsp").forward(request, response);
            }
        } catch (SQLException | ServletException | NumberFormatException e) {
            request.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(request,response);
            throw new RuntimeException(e);
        }
    }
}

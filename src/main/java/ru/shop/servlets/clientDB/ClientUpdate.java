package ru.shop.servlets.clientDB;

import ru.shop.helper.ClientValidateUpdate;
import ru.shop.helper.Connector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/clientLogin/clientUpdate")
public class ClientUpdate extends HttpServlet {
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = Connector.getConn();
        try{
            HttpSession session = request.getSession();
            Statement st = connection.createStatement();
            String client_login = ClientValidateUpdate.validateLogin(request, session);
            String client_name = ClientValidateUpdate.validateName(request, session);
            String client_surNam = ClientValidateUpdate.validateSurName(request, session);
            String client_password = ClientValidateUpdate.validatePassword(request, session);
            int client_ID = (int) session.getAttribute("client_ID");
            st.executeUpdate("UPDATE client SET LOGIN="+"\""+client_login+"\""+",NAME ="+"\""+client_name+"\""+",SURNAME="+"\""+client_surNam+"\""+
                    ",PASSWORD="+"\""+client_password+"\""+"WHERE ID="+"\""+client_ID+"\""+";");
            getServletContext().getRequestDispatcher("/client/cabinet/action_success.jsp").forward(request,response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

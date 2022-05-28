package ru.shop.servlets.clientDB;
import ru.shop.helper.Connector;
import ru.shop.helper.DbToCollectClient;
import ru.shop.models.Client;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.List;
@WebServlet(urlPatterns = "/clientInsert")
public class ClientInsert extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            Connection connection = Connector.getConn();
            String client_surname = req.getParameter("client_surname");
            String client_name = req.getParameter("client_name");
            String client_login = req.getParameter("client_login");
            String client_password = req.getParameter("client_password");
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO client (SURNAME,NAME,LOGIN,PASSWORD) VALUES("+"\"" + client_surname + "\" ,"+ "\"" + client_name+ "\","+
                    "\"" + client_login+ "\","+ "\"" +client_password+"\"" +");");
            connection.close();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }
}
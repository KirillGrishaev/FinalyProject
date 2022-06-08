package ru.shop.servlets.clientDB;
import ru.shop.helper.Connector;
import ru.shop.helper.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(urlPatterns = "/clientLogin/admin/clientInsert")
public class ClientInsert extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            Connection connection = Connector.getConn();
            String client_surname = req.getParameter("client_surname");
            String client_name = req.getParameter("client_name");
            String client_login = req.getParameter("client_login");
            String client_password = req.getParameter("client_password");
            String client_money1 = req.getParameter("client_money");
            int client_money = Validation.validateMoneyClient(req, client_money1);
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO client (SURNAME,NAME,LOGIN,PASSWORD,MONEY) VALUES("+"\"" + client_surname + "\" ,"+ "\"" + client_name+ "\","+
                    "\"" + client_login+ "\","+ "\"" +client_password+"\","+"\"" +client_money+"\"" +");");
            getServletContext().getRequestDispatcher("/admin/insert_success.jsp").forward(req,resp);
        } catch (SQLException | ServletException  e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}
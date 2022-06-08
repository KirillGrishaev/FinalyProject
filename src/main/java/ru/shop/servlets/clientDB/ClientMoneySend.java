package ru.shop.servlets.clientDB;

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
@WebServlet(urlPatterns = "/clientLogin/clientMoneySend")
public class ClientMoneySend extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            Connection connection = Connector.getConn();
            HttpSession session = req.getSession();
            int client_ID = (int) session.getAttribute("client_ID");
            int client_money_now = (int) session.getAttribute("client_money");
            int total_cost = (Integer) session.getAttribute("total_cost");
            if(total_cost>client_money_now){
                req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            }else {
                client_money_now = client_money_now-total_cost;
                Statement st = connection.createStatement();
                st.executeUpdate("UPDATE client SET MONEY="+"\""+client_money_now+"\""+"WHERE ID="+"\""+client_ID+"\""+";");
            }
            getServletContext().getRequestDispatcher("/transactionInsert").forward(req,resp);
        } catch (SQLException | ServletException  e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}

package ru.shop.servlets.clientDB;

import ru.shop.helper.Connector;
import ru.shop.helper.Validation;
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
@WebServlet(urlPatterns = "/clientLogin/clientMoneyUp")
public class ClientMoneyUp extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            Connection connection = Connector.getConn();
            HttpSession session = req.getSession();
            int client_ID = (int) session.getAttribute("client_ID");
            String client_money_up1 = req.getParameter("client_money_up");
            int client_money_up = Validation.validateMoneyUp(req, client_money_up1);
            int client_money_now = (int) session.getAttribute("client_money");
            client_money_up = client_money_now+client_money_up;
            Statement st = connection.createStatement();
            st.executeUpdate("UPDATE client SET MONEY="+"\""+client_money_up+"\""+"WHERE ID="+"\""+client_ID+"\""+";");
            getServletContext().getRequestDispatcher("/client/cabinet/action_success.jsp").forward(req,resp);
        } catch (SQLException | ServletException  e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}

package ru.shop.servlets.clientDB;

import ru.shop.helper.Connector;
import ru.shop.helper.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/clientLogin/admin/clientDelete")
public class ClientDelete extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            String client_ID1 = req.getParameter("client_ID");
            int client_ID = Validation.validateID(req,client_ID1);;
            int rs = st.executeUpdate("DELETE FROM buylist WHERE ID="+"\"" +client_ID+"\""+";");
            int rs1 = st.executeUpdate("DELETE FROM transaction WHERE ID="+"\""+client_ID+"\""+";");
            int rs2 = st.executeUpdate("DELETE FROM client WHERE ID ="+"\""+client_ID+"\""+";");
            req.setAttribute("delete", rs+rs1+rs2);
            getServletContext().getRequestDispatcher("/admin/delete/delete_model.jsp").forward(req,resp);
        } catch (SQLException | ServletException  e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}

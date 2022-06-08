package ru.shop.servlets.clientDB;
import ru.shop.helper.Connector;
import ru.shop.requestResult.client.ClientRequestViewAll;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/clientLogin/admin/clientViewAll")
public class ClientViewAll extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            ArrayList clientList = ClientRequestViewAll.getRequest(st);
            req.setAttribute("clientList", clientList);
            getServletContext().getRequestDispatcher("/admin/admin_view_all_client.jsp").forward(req,resp);
        } catch (SQLException | ServletException e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
        }
    }
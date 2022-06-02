package ru.shop.servlets.clientDB;
import ru.shop.helper.Connector;
import ru.shop.requestResult.client.ClientRequestSearch;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/clientSearch")
public class ClientSearch extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Connection connection = Connector.getConn();
        try{
            Statement st = connection.createStatement();
            req.setAttribute("clientList", ClientRequestSearch.getResult(req,st));
            getServletContext().getRequestDispatcher("/admin/admin_view_all_client.jsp").forward(req,resp);
        } catch (SQLException | ServletException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
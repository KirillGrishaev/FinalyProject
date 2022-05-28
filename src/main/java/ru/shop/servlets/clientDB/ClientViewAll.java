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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@WebServlet(urlPatterns = "/clientViewAll")
public class ClientViewAll extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT ID,SURNAME, NAME,LOGIN,PASSWORD FROM client");
            List<Client> clientList = DbToCollectClient.getCollection(rs);
            req.setAttribute("clientList", clientList);
            getServletContext().getRequestDispatcher("/admin/admin_view_all_client.jsp").forward(req,resp);
            connection.close();
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
        }
    }
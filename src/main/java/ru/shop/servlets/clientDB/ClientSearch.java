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

@WebServlet(urlPatterns = "/clientSearch")
public class ClientSearch extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            int client_id = Integer.parseInt(req.getParameter("client_id"));
            String client_surname = req.getParameter("client_surname");
            String client_name = req.getParameter("client_name");
            String client_login = req.getParameter("client_login");
            String client_password = req.getParameter("client_password");
            ResultSet rs = st.executeQuery("SELECT * FROM client WHERE ID ="+"\""+client_id+"\""+"OR SURNAME ="+"\""+client_surname+"\""
                    +"OR NAME ="+"\""+client_name+"\""+"OR LOGIN ="+"\""+client_login+"\""+"OR PASSWORD ="+"\""+client_password+"\""+";");
            List<Client> clientList = DbToCollectClient.getCollection(rs);
            req.setAttribute("clientList", clientList);
            getServletContext().getRequestDispatcher("/admin/admin_view_all_client.jsp").forward(req,resp);
            //connection.close();
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}

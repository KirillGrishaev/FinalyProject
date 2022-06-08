package ru.shop.servlets.clientDB;
import ru.shop.helper.Connector;
import ru.shop.helper.getCollection.DbToCollectClient;
import ru.shop.models.Client;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@WebServlet(urlPatterns = "/clientLogin/clientCabinet")

public class ClientCabinet extends HttpServlet {
    protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Connection connection = Connector.getConn();
        try{
            HttpSession session = request.getSession();
        Statement st = connection.createStatement();
        String client_login = (String) session.getAttribute("username");
        String client_password = (String) session.getAttribute("password");
        ResultSet rs = st.executeQuery("SELECT * FROM client WHERE LOGIN ="+"\""+client_login+"\""+"AND PASSWORD ="+"\""+client_password+"\""+";");
        List<Client> clientCabinet = DbToCollectClient.getCollection(rs);
        Client client = clientCabinet.get(0);
        int client_ID = client.getId();
        String client_name = client.getName();
        String client_surName = client.getSurName();
        int client_money = client.getMoney();
        int client_role = client.getRole();
        session.setAttribute("client_ID", client_ID);
        session.setAttribute("client_name", client_name);
        session.setAttribute("client_surName", client_surName);
        session.setAttribute("client_money", client_money);
        session.setAttribute("role", client_role);
        request.setAttribute("clientCabinet", clientCabinet);
        request.getServletContext().getRequestDispatcher("/client/cabinet/cabinet_index.jsp").forward(request,response);
        } catch (SQLException | ServletException | NumberFormatException e) {
            request.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(request,response);
            throw new RuntimeException(e);
        }
    }
}

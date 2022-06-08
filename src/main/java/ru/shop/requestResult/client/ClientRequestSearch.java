package ru.shop.requestResult.client;
import ru.shop.helper.getCollection.DbToCollectClient;
import ru.shop.models.Client;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class ClientRequestSearch {
    public static ArrayList getResult(HttpServletRequest req, Statement st) throws SQLException {
        String client_surname = req.getParameter("client_surname");
        String client_name = req.getParameter("client_name");
        String client_login = req.getParameter("client_login");
        String client_password = req.getParameter("client_password");
        ResultSet rs = st.executeQuery("SELECT * FROM client WHERE SURNAME ="+"\""+client_surname+"\""
                +"OR NAME ="+"\""+client_name+"\""+"OR LOGIN ="+"\""+client_login+"\""+"OR PASSWORD ="+"\""+client_password+"\""+";");
        List<Client> clientList = DbToCollectClient.getCollection(rs);
        return (ArrayList) clientList;
    }
}
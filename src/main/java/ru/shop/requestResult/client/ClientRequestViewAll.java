package ru.shop.requestResult.client;
import ru.shop.helper.getCollection.DbToCollectClient;
import ru.shop.models.Client;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientRequestViewAll {
    public static ArrayList getRequest(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT ID,SURNAME, NAME,LOGIN,PASSWORD,MONEY,ROLE FROM client");
        List<Client> clientList = DbToCollectClient.getCollection(rs);
        return (ArrayList) clientList;
    }
}

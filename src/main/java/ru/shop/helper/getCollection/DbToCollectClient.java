package ru.shop.helper.getCollection;

import ru.shop.models.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbToCollectClient {
    public static synchronized ArrayList getCollection(ResultSet rs) throws SQLException {
        List<Client> clientList = new ArrayList<Client>();
        while (rs.next()){
            Client client = new Client();
            client.setId(rs.getInt("ID"));
            client.setSurName(rs.getString("SURNAME"));
            client.setName(rs.getString("NAME"));
            client.setLogin(rs.getString("LOGIN"));
            client.setPassword(rs.getString("PASSWORD"));
            client.setMoney(rs.getInt("MONEY"));
            client.setRole(rs.getInt("ROLE"));
            clientList.add(client);
        }return (ArrayList) clientList;
    }
}

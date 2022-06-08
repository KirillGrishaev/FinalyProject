package ru.shop.requestResult.tovar;
import ru.shop.helper.getCollection.DbToCollectTovar;
import ru.shop.models.Habar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TovarRequestViewAll {
    public static ArrayList getRequest(Statement st) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT article,name,type,cost,weight,rare FROM tovar");
        List<Habar> tovarList = DbToCollectTovar.getCollection(rs);
        return (ArrayList) tovarList;
    }
}

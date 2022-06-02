package ru.shop.helper.getCollection;
import ru.shop.models.Habar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class DbToCollectTovar {
    public static synchronized ArrayList getCollection(ResultSet rs) throws SQLException {
        List<Habar> tovarList = new ArrayList<Habar>();
        while (rs.next()){
            Habar habar = new Habar();
            habar.setArticle(rs.getInt("article"));
            habar.setName(rs.getString("name"));
            habar.setType(rs.getString("type"));
            habar.setCost(rs.getInt("cost"));
            habar.setWeight(rs.getDouble("weight"));
            habar.setRare(rs.getString("rare"));
            tovarList.add(habar);
        }return (ArrayList) tovarList;
    }
}

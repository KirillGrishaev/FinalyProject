package ru.shop.helper.getCollection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class DbToCollectZakaz {
    public static synchronized HashSet getCollection(ResultSet rs) throws SQLException {
        HashSet<Integer> zakazList = new HashSet<>();
        while (rs.next()){
            Integer num_zakaz = rs.getInt("Zakaz");
            zakazList.add(num_zakaz);
        }return (HashSet) zakazList;
    }
}

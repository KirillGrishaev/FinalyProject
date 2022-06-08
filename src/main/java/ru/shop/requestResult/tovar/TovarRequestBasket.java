package ru.shop.requestResult.tovar;

import ru.shop.helper.getCollection.DbToCollectTovar;
import ru.shop.models.Habar;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TovarRequestBasket {
    public static ArrayList getResult(HttpServletRequest req, Statement st) throws SQLException {
        String tovar_name = req.getParameter("tovar_name");
        String tovar_type = req.getParameter("tovar_type");
        int tovar_cost = Integer.parseInt(req.getParameter("tovar_cost"));
        double tovar_weight =Double.parseDouble(req.getParameter("tovar_weight"));
        String tovar_rare = req.getParameter("tovar_rare");
        ResultSet rs = st.executeQuery("SELECT * FROM tovar WHERE name ="+"\""+tovar_name+"\""
                +"AND type ="+"\""+tovar_type+"\""+"AND cost ="+"\""+tovar_cost+"\""+"AND weight ="+"\""+tovar_weight+"\""
                +"AND rare ="+"\""+tovar_rare+"\""+";");
        List<Habar> tovarList = DbToCollectTovar.getCollection(rs);
        return (ArrayList) tovarList;
    }
}

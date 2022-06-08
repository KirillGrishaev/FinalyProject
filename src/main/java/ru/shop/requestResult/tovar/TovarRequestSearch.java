package ru.shop.requestResult.tovar;
import ru.shop.helper.Validation;
import ru.shop.helper.getCollection.DbToCollectTovar;
import ru.shop.models.Habar;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class TovarRequestSearch {
    public static ArrayList getResult(HttpServletRequest req, Statement st) throws SQLException {
        String tovar_name = req.getParameter("tovar_name");
        String tovar_type = req.getParameter("tovar_type");
        String tovar_rare = req.getParameter("tovar_rare");
        String tovar_cost1 = req.getParameter("tovar_cost");
        String tovar_weight1 =req.getParameter("tovar_weight");
        int tovar_cost = Validation.validateCost(req,tovar_cost1);
        double tovar_weight = Validation.validateWeiqht(req,tovar_weight1);
        ResultSet rs = st.executeQuery("SELECT * FROM tovar WHERE name ="+"\""+tovar_name+"\""
                +"OR type ="+"\""+tovar_type+"\""+"OR cost ="+"\""+tovar_cost+"\""+"OR weight ="+"\""+tovar_weight+"\""
                +"OR rare ="+"\""+tovar_rare+"\""+";");
        List<Habar> tovarList = DbToCollectTovar.getCollection(rs);
        return (ArrayList) tovarList;
    }
}
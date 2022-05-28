package ru.shop.servlets.tovarDB;

import ru.shop.helper.Connector;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet(urlPatterns = "/tovarInsert")
public class TovarInsert extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            Connection connection = Connector.getConn();
            String tovar_name = req.getParameter("tovar_name");
            String tovar_type = req.getParameter("tovar_type");
            int tovar_cost = Integer.parseInt(req.getParameter("tovar_cost"));
            double tovar_weight = Double.parseDouble(req.getParameter("tovar_weight"));
            String tovar_rare = req.getParameter("tovar_rare");
            Statement st = connection.createStatement();
            st.executeUpdate("INSERT INTO tovar (name,type,cost,weight,rare) VALUES("+ "\"" + tovar_name+ "\","+ "\"" + tovar_type +
                    "\"," + tovar_cost + "," + tovar_weight+ ","+ "\"" +tovar_rare+"\"" +");");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

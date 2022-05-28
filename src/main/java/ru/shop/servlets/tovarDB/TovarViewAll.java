package ru.shop.servlets.tovarDB;
import ru.shop.helper.Connector;
import ru.shop.helper.DbToCollectTovar;
import ru.shop.models.Habar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@WebServlet(urlPatterns = "/tovarViewAll")
public class TovarViewAll extends HttpServlet {
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT article,name,type,cost,weight,rare FROM tovar");
            List<Habar> tovarList = DbToCollectTovar.getCollection(rs);
            req.setAttribute("tovarList", tovarList);
            getServletContext().getRequestDispatcher("/admin/admin_view_all_tovar.jsp").forward(req,resp);
            connection.close();
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
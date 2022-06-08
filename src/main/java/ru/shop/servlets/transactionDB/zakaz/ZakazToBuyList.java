package ru.shop.servlets.transactionDB.zakaz;
import ru.shop.helper.Connector;
import ru.shop.helper.getCollection.DbToCollectTovar;
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

@WebServlet(urlPatterns = "/clientLogin/zakazList")
public class ZakazToBuyList extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            int num_zakaz = Integer.parseInt(req.getParameter("num_zakaz"));
            ResultSet rs = st.executeQuery("SELECT tovar.*, buylist.article FROM tovar, buylist WHERE buylist.Zakaz ="+"\""+num_zakaz+"\""
                    +"AND buylist.article=tovar.article;");
            List<Habar> tovarList = DbToCollectTovar.getCollection(rs);
            req.setAttribute("tovarList", tovarList);
            getServletContext().getRequestDispatcher("/client/zakazHistory/zakaz_num_observe.jsp").forward(req,resp);
        } catch (SQLException | ServletException | NumberFormatException e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}

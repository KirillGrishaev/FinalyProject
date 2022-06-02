package ru.shop.servlets.transactionDB.zakaz;
import ru.shop.helper.Connector;
import ru.shop.helper.getCollection.DbToCollectZakaz;
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
import java.util.HashSet;

@WebServlet(urlPatterns = "/zakazSearch")
public class IdToZakazSearch extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();

            int client_id = 4;
            //ПРИВЯЗАТЬ ПОЛУЧЕНИЕ ID ОТ СЕССИИ!!!!!!

           // int client_id = Integer.parseInt(req.getParameter("client_id"));
            ResultSet rs = st.executeQuery("SELECT transaction.ID,transaction.Zakaz, buylist.article FROM transaction, buylist" +
                    " WHERE transaction.ID = "+"\""+client_id+"\""+";");
            HashSet<Integer> zakazList = DbToCollectZakaz.getCollection(rs);
            req.setAttribute("zakazList", zakazList);
            getServletContext().getRequestDispatcher("/client/zakazHistory/zakaz_history_observe.jsp").forward(req,resp);
        } catch (SQLException | ServletException | NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}

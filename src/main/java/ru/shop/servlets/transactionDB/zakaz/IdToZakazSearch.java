package ru.shop.servlets.transactionDB.zakaz;
import ru.shop.helper.Connector;
import ru.shop.helper.getCollection.DbToCollectZakaz;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

@WebServlet(urlPatterns = "/clientLogin/zakazSearch")
public class IdToZakazSearch extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Connection connection = Connector.getConn();
        try{
            Statement st = connection.createStatement();
            HttpSession session = req.getSession();
            int client_id = (Integer) session.getAttribute("client_ID");
            ResultSet rs = st.executeQuery("SELECT transaction.ID,transaction.Zakaz, buylist.article FROM transaction, buylist" +
                    " WHERE transaction.ID = "+"\""+client_id+"\""+";");
            HashSet<Integer> zakazList = DbToCollectZakaz.getCollection(rs);
            req.setAttribute("zakazList", zakazList);
            getServletContext().getRequestDispatcher("/client/zakazHistory/zakaz_history_observe.jsp").forward(req,resp);
        } catch (SQLException | ServletException | NumberFormatException e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}
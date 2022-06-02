package ru.shop.servlets.tovarDB;
import ru.shop.helper.Connector;
import ru.shop.requestResult.tovar.TovarRequestSearch;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
@WebServlet(urlPatterns = "/tovarSearch")
public class TovarSearch extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try{
        Connection connection = Connector.getConn();
        Statement st = connection.createStatement();
        req.setAttribute("tovarList", TovarRequestSearch.getResult(req,st));
        getServletContext().getRequestDispatcher("/admin/admin_view_all_tovar.jsp").forward(req,resp);
    } catch (SQLException | ServletException | NumberFormatException e) {
        throw new RuntimeException(e);
    }
}
}
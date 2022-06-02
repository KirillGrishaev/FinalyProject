package ru.shop.servlets.tovarDB;
import ru.shop.helper.Connector;
import ru.shop.requestResult.tovar.TovarRequestViewAll;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/tovarViewAll")
public class TovarViewAll extends HttpServlet {
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            ArrayList tovarList = TovarRequestViewAll.getRequest(st);
            req.setAttribute("tovarList", tovarList);
            getServletContext().getRequestDispatcher("/admin/admin_view_all_tovar.jsp").forward(req,resp);
        } catch (SQLException | ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
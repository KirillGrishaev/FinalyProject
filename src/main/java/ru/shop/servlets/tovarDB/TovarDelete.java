package ru.shop.servlets.tovarDB;
import ru.shop.helper.Connector;
import ru.shop.helper.Validation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/clientLogin/admin/tovarDelete")
public class TovarDelete extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            String tovar_article1 = req.getParameter("tovar_article");
            int tovar_article = Validation.validateArticle(req,tovar_article1);
            int rs = st.executeUpdate("DELETE FROM buylist WHERE article="+"\""+tovar_article+"\""+";");
            int rs1 = st.executeUpdate("DELETE FROM tovar WHERE article="+"\""+tovar_article+"\""+";");
            req.setAttribute("delete", rs+rs1);
            getServletContext().getRequestDispatcher("/admin/delete/delete_model.jsp").forward(req,resp);
        } catch (SQLException | ServletException e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}
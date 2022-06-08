package ru.shop.servlets.transactionDB;

import ru.shop.helper.Connector;
import ru.shop.helper.Helper;
import ru.shop.models.Habar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

@WebServlet(urlPatterns = "/transactionInsert")
public class TransactionInsert extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try{
            Connection connection = Connector.getConn();
            HttpSession session = req.getSession();
            Statement st = connection.createStatement();
            int client_ID = (Integer) session.getAttribute("client_ID");
            int zakaz_num = Helper.getRandomInt();
            ArrayList basketList = (ArrayList) session.getAttribute("basketList");
            if(basketList == null){
                req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            }else {
                st.executeUpdate("INSERT INTO transaction (ID,Zakaz) VALUES("+ client_ID+ ","+ zakaz_num +");");
                Iterator<Habar> basketIterator = basketList.iterator();
                while (basketIterator.hasNext()) {
                    Habar nextHabar = basketIterator.next();
                    int tovar_article = nextHabar.getArticle();
                    st.executeUpdate("INSERT INTO buylist (article,Zakaz,ID) VALUES("+ tovar_article+ ","+ zakaz_num+","+client_ID +");");
                }
                basketList.removeAll(basketList);
                session.setAttribute("basketList", basketList);
            }
            getServletContext().getRequestDispatcher("/client/zakazHistory/zakaz_success.jsp").forward(req,resp);
        } catch (SQLException | ServletException e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}

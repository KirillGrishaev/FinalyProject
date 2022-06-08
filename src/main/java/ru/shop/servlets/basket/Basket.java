package ru.shop.servlets.basket;
import ru.shop.helper.Connector;
import ru.shop.helper.Helper;
import ru.shop.models.Habar;
import ru.shop.requestResult.tovar.TovarRequestBasket;
import ru.shop.requestResult.tovar.TovarRequestSearch;
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


@WebServlet(urlPatterns = "/clientLogin/basket")
public class Basket extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            HttpSession session = req.getSession();
            int total_cost = 0;
            session.setAttribute("total_cost", total_cost);
            ArrayList basketList = (ArrayList) session.getAttribute("basketList");
            if(basketList == null){
                session.setAttribute("basketList", new ArrayList<>());
                basketList = TovarRequestBasket.getResult(req, st);
                session.setAttribute("basketList",basketList);
                total_cost = Helper.costIterator(basketList,total_cost);
                session.setAttribute("total_cost", total_cost);
            }else {
                ArrayList basketList1 = TovarRequestBasket.getResult(req,st);
                basketList.addAll(basketList1);
                total_cost = Helper.costIterator(basketList,total_cost);
                session.setAttribute("total_cost", total_cost);
                session.setAttribute("basketList",basketList);
            }
            getServletContext().getRequestDispatcher("/client/basket.jsp").forward(req,resp);
        } catch (ServletException |SQLException e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        try {
            HttpSession session = req.getSession();
            ArrayList basketList = (ArrayList) session.getAttribute("basketList");
            int remove_all = Integer.parseInt(req.getParameter("remove_all"));
            if (remove_all == 1) {
                basketList.removeAll(basketList);
                session.setAttribute("basketList", basketList);
                getServletContext().getRequestDispatcher("/client/basket.jsp").forward(req, resp);
            } else if (!(remove_all == 1)) {
                String tovar_name = req.getParameter("tovar_name");
                String tovar_type = req.getParameter("tovar_type");
                Iterator<Habar> habarIterator = basketList.iterator();
                while (habarIterator.hasNext()) {
                    Habar nextHabar = habarIterator.next();
                    if (nextHabar.getName().equals(tovar_name) && nextHabar.getType().equals(tovar_type)) {
                        habarIterator.remove();
                    }
                }
                session.setAttribute("basketList", basketList);
                getServletContext().getRequestDispatcher("/client/basket.jsp").forward(req, resp);
            }
        } catch (ServletException e) {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
            throw new RuntimeException(e);
        }
    }
}
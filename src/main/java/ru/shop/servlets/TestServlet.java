package ru.shop.servlets;

import ru.shop.helper.Connector;
import ru.shop.helper.DbToCollectClient;
import ru.shop.models.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try{
            Connection connection = Connector.getConn();
            Statement st = connection.createStatement();
            String client_surname = "sss1";
            String client_name = "sss2";
            String client_login = "sss3";
            String client_password = "sss4";
            st.executeUpdate("INSERT INTO client (SURNAME,NAME,LOGIN,PASSWORD) VALUES("+"\"" + client_surname + "\" ,"+ "\"" + client_name+ "\","+ "\"" + client_login+ "\","+ "\"" +client_password+"\"" +");");
            System.out.println(st);
            connection.close();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

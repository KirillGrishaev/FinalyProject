package ru.shop.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ClientValidateUpdate {

    public static String validateLogin (HttpServletRequest req,HttpSession session) {
        String client_login = req.getParameter("client_login");
        if (client_login=="") {
            client_login = (String) session.getAttribute("username");
            return client_login;
        }
        return client_login;
    }

    public static String validateName (HttpServletRequest req,HttpSession session) {
        String client_name = req.getParameter("client_name");
        if (client_name=="") {
            client_name = (String) session.getAttribute("client_name");
            return client_name;
        }
        return client_name;
    }
    public static String validateSurName (HttpServletRequest req,HttpSession session) {
        String client_surName = req.getParameter("client_surName");
        if (client_surName=="") {
            client_surName = (String) session.getAttribute("client_surName");
            return client_surName;
        }
        return client_surName;
    }
    public static String validatePassword (HttpServletRequest req,HttpSession session) {
        String client_password = req.getParameter("client_password");
        if (client_password=="") {
            client_password = (String) session.getAttribute("password");
            return client_password;
        }
        return client_password;
    }
}

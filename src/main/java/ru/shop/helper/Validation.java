package ru.shop.helper;

import javax.servlet.http.HttpServletRequest;

public class Validation {
    public static int validateID(HttpServletRequest req, String client_ID1) {
        int client_ID;
        if (client_ID1 == "") {
            client_ID = 0;
            return client_ID;
        } else {
            client_ID = Integer.parseInt(req.getParameter("client_ID"));
        }
        return client_ID;
    }
    public static int validateCost(HttpServletRequest req, String tovar_cost1) {
        int tovar_cost;
        if (tovar_cost1 == "") {
            tovar_cost = 0;
            return tovar_cost;
        } else {
            tovar_cost = Integer.parseInt(req.getParameter("tovar_cost"));
        }
        return tovar_cost;
    }
    public static int validateArticle(HttpServletRequest req, String tovar_article1) {
        int tovar_article;
        if (tovar_article1 == "") {
            tovar_article = 0;
            return tovar_article;
        } else {
            tovar_article = Integer.parseInt(req.getParameter("tovar_article"));
        }
        return tovar_article;
    }
    public static double validateWeiqht(HttpServletRequest req, String tovar_weight1) {
        double tovar_weight;
        if (tovar_weight1 == "") {
            tovar_weight = 0;
            return tovar_weight;
        } else {
            tovar_weight = Double.parseDouble(req.getParameter("tovar_weight"));
        }
        return tovar_weight;
    }
    public static int validateMoneyUp(HttpServletRequest req, String client_money1) {
        int client_money;
        if (client_money1 == "") {
            client_money = 0;
            return client_money;
        } else {
            client_money = Integer.parseInt(req.getParameter("client_money_up"));
        }
        return client_money;
    }
    public static int validateMoneyClient(HttpServletRequest req, String client_money1) {
        int client_money;
        if (client_money1 == "") {
            client_money = 0;
            return client_money;
        } else {
            client_money = Integer.parseInt(req.getParameter("client_money"));
        }
        return client_money;
    }

}

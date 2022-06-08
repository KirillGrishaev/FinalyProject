package ru.shop.servlets.security;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns ="/admin/*")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try{ HttpSession session = req.getSession();
        int role = (int) session.getAttribute("role");
        if (role == 2){
            chain.doFilter(request, response);
        }else {
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
        }
        }catch (NullPointerException e){
            req.getServletContext().getRequestDispatcher("/client/login/error.jsp").forward(req,resp);
        }

    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}


package br.com.restaurante.servlet;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/reserva"})
public class Filtro implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession sessao = req.getSession(false);

        String URL = req.getContextPath() + "/login";
        boolean isLoginRequest = req.getRequestURI().equals(URL);

        if(req.getServletPath().equals("/console")) {
            chain.doFilter(request, response);
            return;
        }

        if(sessao == null || sessao.getAttribute("email") == null) {
            if(isLoginRequest) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect("login");
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}

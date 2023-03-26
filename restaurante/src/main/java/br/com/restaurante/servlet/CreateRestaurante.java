package br.com.restaurante.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class CreateRestaurante extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String email= request.getParameter("email");

        String senha= request.getParameter("password");

        System.out.println("Email" + email + "Senha: " + senha);

        request.getRequestDispatcher("reserva.html").forward(request, response);
    }
}

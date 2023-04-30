package br.com.restaurante.servlet;

import br.com.restaurante.dao.LoginDao;
import br.com.restaurante.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class CreateLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try{
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Client cliente = new Client();
        cliente.setEmail(email);
        cliente.setPassword(password);

        LoginDao clienteDao = new LoginDao();


        if(clienteDao.validarLogin(email, password)){
           response.sendRedirect(".html");

        }else{
            request.setAttribute("Error", "Usuário e/ou senha inválidos.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
            dispatcher.forward(request,response);
        }
    }catch (Exception e){
        System.out.println(e + "erro");
    }
    }
}

package br.com.restaurante.servlet;

import br.com.restaurante.dao.ClientDao;
import br.com.restaurante.dao.LoginDao;
import br.com.restaurante.model.Client;
import br.com.restaurante.model.Employee;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try{
        String email = request.getParameter("email");
        String password = request.getParameter("password");


        Client cliente = new Client();
        cliente.setEmail(email);
        cliente.setPassword(password);

        Employee employee = new Employee();
        employee.setEmail(email);
        employee.setPassword(password);

        boolean valido = new LoginDao().validarLogin(cliente);
        boolean validoF = new LoginDao().validarLoginF(employee);


        if(valido){

            request.getSession().setAttribute("email", email);
            response.sendRedirect("/perfil-cliente");

        } else if (validoF) {
            request.getSession().setAttribute("email", email);
            response.sendRedirect("/perfil-funcionario");

        } else{
            request.setAttribute("Error", "Usuário e/ou senha inválidos.");

            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }catch (Exception e){
        System.out.println(e + "erro");
    }
    }



}

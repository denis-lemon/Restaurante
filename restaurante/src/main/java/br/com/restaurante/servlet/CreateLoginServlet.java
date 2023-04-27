package br.com.restaurante.servlet;

import br.com.restaurante.dao.LoginDao;
import br.com.restaurante.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet("/login")
public class CreateLoginServlet extends HttpServlet {
private static  final long serialVersionUID =1L;
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("login.html");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    try{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Client cliente = new Client();

        LoginDao clienteDao = new LoginDao();
        ResultSet rsClienteDao = clienteDao.validarLogin(cliente);

        if(rsClienteDao.next()){
           RequestDispatcher rd = request.getRequestDispatcher("Reserva.html");
           rd.forward(request, response);
        }else{
            System.out.println("Usuário e/ou senha incorretos.");
        }
    }catch (Exception e){
        System.out.println(e + "erro");
    }
    }
}

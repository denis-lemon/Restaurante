package br.com.restaurante.servlet;

import br.com.restaurante.dao.ClientDao;
import br.com.restaurante.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/perfil-cliente")
public class PerfilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String emailCliente = (String) req.getSession().getAttribute("email");

            if(emailCliente !=null) {
                Client cliente = new ClientDao().selecionarCliente(emailCliente);

                req.setAttribute("cliente", cliente);

                req.getRequestDispatcher("PerfilCliente.jsp").forward(req, resp);

            } else {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
    } catch (Exception exception){

        System.out.println(exception);

    }

}
        }

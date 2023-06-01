package br.com.restaurante.servlet;

import br.com.restaurante.dao.ClientDao;
import br.com.restaurante.dao.ReservaDao;
import br.com.restaurante.model.Client;
import br.com.restaurante.model.Reserva;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String emailCliente = (String) req.getSession().getAttribute("email");

            if (emailCliente != null) {

                Client cliente = new ClientDao().selecionarCliente(emailCliente);

                req.setAttribute("cliente", cliente);

                req.getRequestDispatcher("home.jsp").forward(req, resp);

            } else {
                req.getRequestDispatcher("home.html").forward(req, resp);
            }
        } catch (Exception exception) {

            System.out.println(exception);

        }

    }

}

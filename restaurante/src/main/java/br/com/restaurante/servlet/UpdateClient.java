package br.com.restaurante.servlet;

import br.com.restaurante.dao.ClientDao;
import br.com.restaurante.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.ImagingOpException;
import java.io.IOException;

@WebServlet("/update-cliente")
public class UpdateClient extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, ImagingOpException, IOException {

        String emailCliente = req.getParameter("email");


        if (emailCliente != null) {
            Client cliente = ClientDao.getClienteByEmail(emailCliente);

            if (cliente != null) {

                req.setAttribute("cliente", cliente);

                req.getRequestDispatcher("UpdateCliente.jsp").forward(req, resp);

            } else {
                resp.sendRedirect("/Home");
            }

        } else {
            resp.sendRedirect("/Home");
        }
    }

}

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
            Client cliente = ClientDao.selecionarCliente(emailCliente);

            if (cliente != null) {

                req.setAttribute("cliente", cliente);

                req.getRequestDispatcher("UpdateCliente.jsp").forward(req, resp);

            } else {
                resp.sendRedirect("/perfil-cliente");
            }

        } else {
            resp.sendRedirect("/Home");
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost() method called");
        String emailCliente = req.getParameter("email");
        String nomeCliente = req.getParameter("name");
        String senhaCliente = req.getParameter("password");
        String idCliente = req.getParameter("id");

        Client cliente = new Client();

        cliente.setName(nomeCliente);
        cliente.setEmail(emailCliente);
        cliente.setPassword(senhaCliente);
        cliente.setId(idCliente);

        boolean sucesso = ClientDao.updateCliente(cliente);

        if (sucesso) {
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("perfil-cliente");
        }

    }

}

package br.com.restaurante.servlet;

import br.com.restaurante.dao.ClientDao;
import br.com.restaurante.model.Client;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/resetSenha")
public class ResetSenhaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ResetSenha.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        String clienteEmail = req.getParameter("clienteEmail");


        if (!password.equals(confirmPassword)) {
            resp.sendRedirect("erro.html"); // Redirecionar para página de erro de senha não coincidente
            return;
        }
        String hashPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        ClientDao clientDao = new ClientDao();
        Client client1 = new Client();
        client1.setEmail(clienteEmail);
        client1.setPassword(hashPassword);

        clientDao.atualizar(client1);




        resp.sendRedirect("sucesso.html"); // Redirecionar para página de sucesso de redefinição de senha
    }
}


package br.com.restaurante.servlet;

import br.com.restaurante.dao.ClientDao;
import br.com.restaurante.model.Client;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create-client")
public class CreateClientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Client client = new Client();
        client.setName(name);
        client.setLastName(lastName);
        client.setCpf(cpf);
        client.setEmail(email);
        client.setPassword(password);

        new ClientDao().createClient(client);


        request.getRequestDispatcher("Cadastro.html").forward(request, response);
    }
}

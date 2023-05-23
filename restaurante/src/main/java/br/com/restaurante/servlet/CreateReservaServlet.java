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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet("/reserva")
public class CreateReservaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String email = (String) request.getSession().getAttribute("email");

            Client cliente = ClientDao.selecionarCliente(email);

            String clienteId = cliente.getId();
            String clienteNome = cliente.getName();
            String clienteEmail = cliente.getEmail();


            String data = request.getParameter("data");
            String hora = request.getParameter("hora");
            String qntPessoas = request.getParameter("qntPessoas");
            String ambiente = request.getParameter("ambiente");
            String obs = request.getParameter("extra");




            Reserva reserva = new Reserva();
            reserva.setData(data);
            reserva.setHora(hora);
            reserva.setQntPessoas(qntPessoas);
            reserva.setAmbiente(ambiente);
            reserva.setObs(obs);
            reserva.setNome(clienteNome);
            reserva.setEmail(clienteEmail);
            reserva.setClienteId(clienteId);

            new ReservaDao().createReserva(reserva);


            request.getRequestDispatcher("ReservaConcluida.html").forward(request, response);
        } catch (Exception e) {
            System.out.println(e + "erro");
        }


    }
}

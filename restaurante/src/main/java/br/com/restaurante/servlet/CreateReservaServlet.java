package br.com.restaurante.servlet;

import br.com.restaurante.dao.ReservaDao;
import br.com.restaurante.model.Reserva;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

@WebServlet("/reserva")
public class CreateReservaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String data = request.getParameter("data");
        String hora = request.getParameter("hora");
        String qntPessoas = request.getParameter("qntPessoas");
        String ambiente = request.getParameter("ambiente");
        String obs = request.getParameter("obs");

        Reserva reserva = new Reserva();
        reserva.setData(data);
        reserva.setHora(hora);
        reserva.setQntPessoas(qntPessoas);
        reserva.setAmbiente(ambiente);
        reserva.setObs(obs);

        new ReservaDao().createReserva(reserva);


        request.getRequestDispatcher("ReservaConcluida.html").forward(request, response);
    }



}

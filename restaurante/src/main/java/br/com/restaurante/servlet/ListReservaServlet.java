package br.com.restaurante.servlet;

import br.com.restaurante.dao.ReservaDao;
import br.com.restaurante.model.Reserva;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listar-reservas")
public class ListReservaServlet extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Reserva> reservas = new ReservaDao().listarReservas();

        req.setAttribute("reservas", reservas);
        req.getRequestDispatcher("ListaReservas.jsp").forward(req, resp);
    }

}

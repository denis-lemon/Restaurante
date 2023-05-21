package br.com.restaurante.servlet;

import br.com.restaurante.dao.ReservaDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteReservaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reservaId = req.getParameter("id");

        if(reservaId !=null && !reservaId.isEmpty()){
            ReservaDao reservaDao = new ReservaDao();
            reservaDao.deleteReserva(reservaId);
        }
        resp.sendRedirect("/listar-reservas");
    }
}

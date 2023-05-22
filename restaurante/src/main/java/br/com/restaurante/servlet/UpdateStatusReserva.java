package br.com.restaurante.servlet;

import br.com.restaurante.dao.ReservaDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-reserva")
public class UpdateStatusReserva extends HttpServlet {


        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String reservaId = request.getParameter("id");

            // Atualizar o status da reserva para "confirmado" no banco de dados
            boolean sucesso = ReservaDao.updateReserva(reservaId, "confirmado");

            if (sucesso) {
                // Redirecionar de volta para a página de listagem de reservas
                response.sendRedirect("/listar-reservas");
            } else {
                // Lidar com o erro, se necessário
                // ...
            }
        }
    }





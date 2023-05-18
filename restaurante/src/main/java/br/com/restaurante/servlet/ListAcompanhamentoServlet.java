package br.com.restaurante.servlet;

import br.com.restaurante.dao.PratoDao;
import br.com.restaurante.model.Prato;

import javax.servlet.http.HttpServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listar-acompanhamentos")
public class ListAcompanhamentoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Prato> pratos = new PratoDao().findAllAcompanhamentos();

        req.setAttribute("pratos", pratos);

        req.getRequestDispatcher("Acompanhamentos.jsp").forward(req, resp);
    }
}

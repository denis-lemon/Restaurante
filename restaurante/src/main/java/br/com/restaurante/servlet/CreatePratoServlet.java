package br.com.restaurante.servlet;

import br.com.restaurante.dao.PratoDao;
import br.com.restaurante.model.Prato;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/adicionarPrato")
public class CreatePratoServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        String descricao = request.getParameter("descricao");

        Prato prato = new Prato();
        prato.setNome(nome);
        prato.setTipo(tipo);
        prato.setDescricao(descricao);

        new PratoDao().createPrato(prato);

        request.getRequestDispatcher("Cardapio.html").forward(request, response);

    }



}

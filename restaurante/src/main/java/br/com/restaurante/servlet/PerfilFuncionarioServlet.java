package br.com.restaurante.servlet;

import br.com.restaurante.dao.EmployeeDao;
import br.com.restaurante.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/perfil-funcionario")
public class PerfilFuncionarioServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String emailFuncionario = (String) req.getSession().getAttribute("email");

            if (emailFuncionario != null) {

                Employee funcionario = EmployeeDao.selecionarFuncionario(emailFuncionario);

                req.setAttribute("funcionario", funcionario);

                req.getRequestDispatcher("PerfilFuncionario.jsp").forward(req, resp);

            } else {
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }
}

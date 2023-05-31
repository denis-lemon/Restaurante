package br.com.restaurante.servlet;

import br.com.restaurante.dao.EmployeeDao;
import br.com.restaurante.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update-funcionario")
public class UpdateEmployee extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String emailFuncionario = req.getParameter("email");

        if(emailFuncionario != null) {

            Employee funcionario = EmployeeDao.selecionarFuncionario(emailFuncionario);

            if(funcionario != null) {

                req.setAttribute("funcionario", funcionario);

                req.getRequestDispatcher("UpdateFuncionario.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("perfil-funcionario");

            }
            } else {
                resp.sendRedirect("/Home");
            }


        }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost() method called");
        String emailFuncionario = req.getParameter("email");
        String nomeFuncionario = req.getParameter("name");
        String senhaFuncionario = req.getParameter("password");
        String idFuncionario = req.getParameter("id");

        Employee funcionario = new Employee();

        funcionario.setName(nomeFuncionario);
        funcionario.setEmail(emailFuncionario);
        funcionario.setPassword(senhaFuncionario);
        funcionario.setId(idFuncionario);

        boolean sucesso = EmployeeDao.updateFuncionario(funcionario);

        if (sucesso) {
            resp.sendRedirect("/login");
        } else {
            resp.sendRedirect("perfil-funcionario");
        }

    }

}


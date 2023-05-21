package br.com.restaurante.servlet;

import br.com.restaurante.dao.EmployeeDao;
import br.com.restaurante.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/listar-funcionarios")
public class ListFuncionariosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Employee> employees = new EmployeeDao().listarEmployee();

        req.setAttribute("employees", employees);
        req.getRequestDispatcher("ListaFuncionarios.jsp").forward(req,resp);
    }
}

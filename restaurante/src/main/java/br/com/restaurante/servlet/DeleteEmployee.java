package br.com.restaurante.servlet;

import br.com.restaurante.dao.EmployeeDao;
import br.com.restaurante.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/delete-funcionario")
public class DeleteEmployee extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employeeId = req.getParameter("id");

        if(employeeId !=null && !employeeId.isEmpty()){
            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.deleteEmployee(employeeId);
        }

        resp.sendRedirect("/listar-funcionarios");
    }
}

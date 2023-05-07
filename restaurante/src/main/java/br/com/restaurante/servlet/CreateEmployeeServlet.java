package br.com.restaurante.servlet;

import br.com.restaurante.dao.ClientDao;
import br.com.restaurante.dao.EmployeeDao;
import br.com.restaurante.model.Client;
import br.com.restaurante.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/create-employee"})
public class CreateEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setLastName(lastName);
        employee.setCpf(cpf);
        employee.setEmail(email);
        employee.setPassword(password);

        new EmployeeDao().createEmployee(employee);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }


}

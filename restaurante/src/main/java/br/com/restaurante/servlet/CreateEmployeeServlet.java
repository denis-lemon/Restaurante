package br.com.restaurante.servlet;

import br.com.restaurante.dao.EmployeeDao;
import br.com.restaurante.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/create-employee"})
public class CreateEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("CadastroFuncionario.jsp").forward(req, resp);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        List<String> mensagemErro = validarcampos(name, lastName, cpf, email, password);

        if(mensagemErro.isEmpty()){
        Employee employee = new Employee(name,lastName,cpf,email,password);

        employee.setName(name);
        employee.setLastName(lastName);
        employee.setCpf(cpf);
        employee.setEmail(email);
        employee.setPassword(password);

        new EmployeeDao().createEmployee(employee);

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
        else{
            String primeiraMensagemErro = mensagemErro.get(0);
            response.getWriter().write("<script>exibirAlertaErro('" + primeiraMensagemErro + "');</script>");
            request.getRequestDispatcher("CadastroFuncionario.jsp").forward(request,response);
        }
}
    private List<String> validarcampos(String name, String lastName, String cpf, String email, String password) {

        List<String> mensagemErro = new ArrayList<>();
        if (name == null || name.isEmpty() || name.length() > 30) {
            mensagemErro.add("Deve ter no máximo 30 caracteres");
        }
        if (lastName == null || lastName.isEmpty() || lastName.length() > 100) {
            mensagemErro.add("O campo está vazio");
        }
        if (cpf.length() != 15 || !cpf.matches("\\d{11}")) {
            mensagemErro.add("O cpf deve 15 caracteres e conter apenas números.");
        }
        if (email == null || email.isEmpty() || email.length() > 100) {
            mensagemErro.add("O email deve ter no máximo 100 caracteres.");
        }

        if (password.length() < 8 || !password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*\\.).+$")) {
            mensagemErro.add("A senha deve ter no mínimo 8 caracteres, contendo pelo menos uma letra, um número e um ponto.");
        }
        return mensagemErro;
    }
}

package br.com.restaurante.dao;

import br.com.restaurante.model.Employee;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeDao {

    public void createEmployee(Employee employee) {
        String SQL = "INSERT INTO EMPLOYEE (NAME, LASTNAME, CPF, EMAIL, PASSWORD) VALUES (?, ?, ?, ?,?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            String hashPassword = BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt());


            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getCpf());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5, hashPassword);


            preparedStatement.execute();
            connection.close();

            System.out.println("success in connection");
        } catch (Exception e) {

            System.out.println("fail in connection" + e.getMessage());
            e.printStackTrace();
        }

    }

    public static ArrayList<Employee> listarEmployee() {

        ArrayList<Employee> employees = new ArrayList<>();

        String SQL = "SELECT ID, NAME, LASTNAME, CPF, EMAIL FROM EMPLOYEE";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String lastName = rs.getString(3);
                String cpf = rs.getString(4);
                String email = rs.getString(5);

                Employee employee = new Employee();
                employees.add(employee);

                employee.setId(id);
                employee.setName(name);
                employee.setLastName(lastName);
                employee.setCpf(cpf);
                employee.setEmail(email);

            }
            System.out.println("sucess in Select * employees");
            connection.close();
            return employees;

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("fail in database connection");

            return null;
        }
    }

    public void deleteEmployee(String employeeId) {

        String SQL = "DELETE FROM EMPLOYEE WHERE ID = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, employeeId);

            preparedStatement.execute();

            System.out.println("success on delete employee with id: " + employeeId);

            connection.close();


        } catch (SQLException e) {

            System.out.println(e);
        }
    }

    public static Employee selecionarFuncionario(String email) {

        Employee funcionario = new Employee();

        String SQL = "SELECT * FROM EMPLOYEE WHERE EMAIL = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String lastname = rs.getString(3);
                String cpf = rs.getString(4);
                String emailFuncionario = rs.getString(5);

                funcionario.setId(id);
                funcionario.setName(name);
                funcionario.setLastName(lastname);
                funcionario.setCpf(cpf);
                funcionario.setEmail(emailFuncionario);

                return funcionario;

            }
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        return funcionario;
    }

    public static boolean updateFuncionario(Employee funcionario) {
        String SQL = "UPDATE EMPLOYEE SET NAME = ?, LASTNAME = ?,  EMAIL = ?, PASSWORD = ? WHERE ID = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            String hashPassword = BCrypt.hashpw(funcionario.getPassword(), BCrypt.gensalt());


            preparedStatement.setString(1, funcionario.getName());
            preparedStatement.setString(2, funcionario.getLastName());
            preparedStatement.setString(3, funcionario.getEmail());
            preparedStatement.setString(4, hashPassword);
            preparedStatement.setString(5, funcionario.getId());

            int linhasAfetadas = preparedStatement.executeUpdate();

            connection.close();

            System.out.println("sucess");
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("error");
            return false;
        }

    }
}





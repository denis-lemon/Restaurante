package br.com.restaurante.dao;

import br.com.restaurante.model.Employee;

import java.sql.*;
import java.util.ArrayList;


public class EmployeeDao {
    public void createEmployee(Employee employee){
        String SQL = "INSERT INTO EMPLOYEE (NAME, LASTNAME, CPF, EMAIL, PASSWORD) VALUES (?, ?, ?, ?,?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getCpf());
            preparedStatement.setString(4, employee.getEmail());
            preparedStatement.setString(5,employee.getPassword());


            preparedStatement.execute();
            connection.close();

            System.out.println("success in connection");
        } catch (Exception e){

            System.out.println("fail in connection"+ e.getMessage());
            e.printStackTrace();
        }

    }

    public static ArrayList<Employee> listarEmployee() {

        ArrayList<Employee> employees = new ArrayList<>();

        String SQL = "SELECT ID, NAME, LASTNAME, CPF, EMAIL FROM EMPLOYEE";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
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

        }catch (Exception e){
            System.out.println(e);
            System.out.println("fail in database connection");

            return null;
        }
    }
    public void deleteEmployee(String employeeId){

        String SQL = "DELETE FROM EMPLOYEE WHERE ID = ?";

        try{
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
}




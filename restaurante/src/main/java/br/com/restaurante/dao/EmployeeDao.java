package br.com.restaurante.dao;

import br.com.restaurante.model.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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

    }




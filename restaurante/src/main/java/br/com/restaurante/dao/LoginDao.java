package br.com.restaurante.dao;


import br.com.restaurante.model.Client;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDao {

    public ResultSet validarLogin(Client cliente){
    String SQL = "SELECT * FROM CLIENTE WHERE email =? AND PASSWORD=?";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
            System.out.println("sucess in connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, cliente.getEmail());
            preparedStatement.setString(2,cliente.getPassword());

            ResultSet rs = preparedStatement.executeQuery();

            return rs;

        }catch (Exception e){
            System.out.println("Fail in connection da valida��o");
            return null;
        }
    }

}
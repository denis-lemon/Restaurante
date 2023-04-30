package br.com.restaurante.dao;


import br.com.restaurante.model.Client;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDao {

    public boolean validarLogin(String email, String password){
    String SQL = "SELECT * FROM CLIENTE WHERE email =? AND PASSWORD=?";

    boolean valido = false;
        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
            System.out.println("sucess in connection");

            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                valido = true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return valido;
    }

}
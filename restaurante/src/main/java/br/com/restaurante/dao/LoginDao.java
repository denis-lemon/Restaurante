package br.com.restaurante.dao;


import br.com.restaurante.model.Client;
import org.jasypt.util.password.StrongPasswordEncryptor;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDao {

    public boolean validarLogin(Client client){
    String SQL = "SELECT * FROM CLIENTE WHERE email =?";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
            System.out.println("sucess in connection");

            PreparedStatement ps = connection.prepareStatement(SQL);


            ps.setString(1, client.getEmail());
            ResultSet rs = ps.executeQuery();



            while(rs.next()) {

                String password = rs.getString("password");
                if(password.equals(client.getPassword())){
                    return true;
                }
            }
            connection.close();

            return false;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
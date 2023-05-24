package br.com.restaurante.dao;


import br.com.restaurante.model.Client;
import br.com.restaurante.model.Employee;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;



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

                String hashPassword = rs.getString("password");
                if(BCrypt.checkpw(client.getPassword(), hashPassword)){
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
    public boolean validarLoginF(Employee employee){
        String SQL = "SELECT * FROM EMPLOYEE WHERE email =?";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
            System.out.println("sucess in connection");

            PreparedStatement ps = connection.prepareStatement(SQL);


            ps.setString(1, employee.getEmail());
            ResultSet rs = ps.executeQuery();



            while(rs.next()) {

                String hashPassword = rs.getString("password");
                if(BCrypt.checkpw(employee.getPassword(), hashPassword)){
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
package br.com.restaurante.dao;


import br.com.restaurante.model.Client;
import br.com.restaurante.model.Employee;

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
    public boolean validarLoginF(Employee employee){
        String SQL = "SELECT * FROM EMPLOYEE WHERE email =?";

        try{
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","sa");
            System.out.println("sucess in connection");

            PreparedStatement ps = connection.prepareStatement(SQL);


            ps.setString(1, employee.getEmail());
            ResultSet rs = ps.executeQuery();



            while(rs.next()) {

                String password = rs.getString("password");
                if(password.equals(employee.getPassword())){
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
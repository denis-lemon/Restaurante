package br.com.restaurante.dao;

import br.com.restaurante.model.Client;

import java.sql.*;
import java.util.ArrayList;


public class ClientDao {

    public void createClient(Client client){
        String SQL = "INSERT INTO CLIENTE (NAME, LASTNAME, CPF, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getCpf());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5,client.getPassword());

            preparedStatement.execute();
            connection.close();

            System.out.println("success in connection");
        } catch (Exception e){

            System.out.println("fail in connection"+ e.getMessage());
            e.printStackTrace();
        }
    }
    public static ArrayList<Client> listarClientes(){

        ArrayList<Client> clients = new ArrayList<>();

        String SQL= "SELECT ID, NAME, LASTNAME, CPF, EMAIL FROM CLIENTE WHERE ID = ? , NAME = ?, LASTNAME = ?, CPF = ?, EMAIL = ?";

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

            }
            System.out.println("sucess in Select * clientes");
            connection.close();
            return clients;

        }catch (Exception e){
            System.out.println(e);
            System.out.println("fail in database connection");

            return null;
        }

    }
}

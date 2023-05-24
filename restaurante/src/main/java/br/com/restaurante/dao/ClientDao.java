package br.com.restaurante.dao;

import br.com.restaurante.model.Client;
import org.mindrot.jbcrypt.BCrypt;


import java.sql.*;
import java.util.ArrayList;


public class ClientDao {

    public void createClient(Client client) {
        String SQL = "INSERT INTO CLIENTE (NAME, LASTNAME, CPF, EMAIL, PASSWORD) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            String hashPassword = BCrypt.hashpw(client.getPassword(), BCrypt.gensalt());

            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getCpf());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setString(5, hashPassword);

            preparedStatement.execute();
            connection.close();

            System.out.println("success in connection");
        } catch (Exception e) {

            System.out.println("falha ao inserir" +e);
            e.printStackTrace();
        }
    }

    public static ArrayList<Client> listarClientes() {

        ArrayList<Client> clients = new ArrayList<>();

        String SQL = "SELECT ID, NAME, LASTNAME, CPF, EMAIL FROM CLIENTE";

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

                Client c = new Client();
                clients.add(c);

                c.setId(id);
                c.setName(name);
                c.setLastName(lastName);
                c.setCpf(cpf);
                c.setEmail(email);


            }
            System.out.println("sucess in Select * clientes");
            connection.close();
            return clients;

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("fail in database connection");

            return null;
        }

    }

    public static Client selecionarCliente(String email) {

        Client cliente = new Client();

        String SQL = "SELECT * FROM CLIENTE WHERE EMAIL = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String lastname = rs.getString(3);
                String cpf = rs.getString(4);
                String emailCliente = rs.getString(5);

                cliente.setId(id);
                cliente.setName(name);
                cliente.setLastName(lastname);
                cliente.setCpf(cpf);
                cliente.setEmail(emailCliente);

                return cliente;
            }

            connection.close();

        } catch(Exception e) {
            System.out.println(e);
        }

        return cliente;
    }

    public String getClientIdByEmail(String email) {

        String clienteId = null;

        String SQL = "SELECT ID FROM CLIENTE WHERE EMAIL = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, email);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                clienteId = rs.getString("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clienteId;


    }
}

package br.com.restaurante.dao;

import br.com.restaurante.model.Prato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PratoDao {

    public void createPrato(Prato prato){
        String SQL = "INSERT INTO CARDAPIO (NOME, TIPO, DESCRICAO, PRECO) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setString(1, prato.getNome());
            preparedStatement.setString(2, prato.getTipo());
            preparedStatement.setString(3, prato.getDescricao());
            preparedStatement.setString(4, prato.getPreco());

            preparedStatement.execute();
            connection.close();

            System.out.println("success in connection");
        } catch (Exception e){

            System.out.println("fail in connection"+ e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<Prato> findAllPratos(){

        ArrayList<Prato> pratos = new ArrayList<>();

        String SQL = "SELECT * FROM CARDAPIO";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();



            while (resultSet.next()) {

                int pratoId = resultSet.getInt("id");
                String Nome = resultSet.getString("nome");
                String tipo = resultSet.getString("tipo");
                String descricao = resultSet.getString("descricao");
                String preco = resultSet.getString("preco");

                Prato prato = new Prato(pratoId, Nome, tipo, descricao,preco);

                pratos.add(prato);

            }

            System.out.println("success in select * car");

            connection.close();

            return pratos;

        } catch (Exception e) {

            System.out.println("fail in database connection"+ e.getCause());
            e.printStackTrace();
            return null;
        }


    }
    public void deletePratoById(String id){
        String SQL = "DELETE CARDAPIO WHERE ID = ?";

        try{

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1, id);
            preparedStatement.execute();

            System.out.println("success on delete cardapio with id: " + id);

            connection.close();

        }catch (Exception e){
            System.out.println("Fail in database connection");
        }


    }



}

package br.com.restaurante.dao;

import br.com.restaurante.model.Prato;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PratoDao {

    public void createPrato(Prato prato){
        String SQL = "INSERT INTO CARDAPIO (NOME, TIPO, DESCRICAO) VALUES (?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setString(1, prato.getNome());
            preparedStatement.setString(2, prato.getTipo());
            preparedStatement.setString(3, prato.getDescricao());

            preparedStatement.execute();
            connection.close();

            System.out.println("success in connection");
        } catch (Exception e){

            System.out.println("fail in connection"+ e.getMessage());
            e.printStackTrace();
        }
    }

}

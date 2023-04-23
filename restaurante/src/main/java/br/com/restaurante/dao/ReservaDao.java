package br.com.restaurante.dao;

import br.com.restaurante.model.Reserva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ReservaDao {

    public void createReserva(Reserva reserva){
        String SQL = "INSERT INTO RESERVAS (DATA, HORA, QNTPESSOAS, AMBIENTE, OBS) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setString(1, reserva.getData());
            preparedStatement.setString(2, reserva.getHora());
            preparedStatement.setString(3, reserva.getQntPessoas());
            preparedStatement.setString(4, reserva.getAmbiente());
            preparedStatement.setString(5, reserva.getObs());

            preparedStatement.execute();
            connection.close();

            System.out.println("success in connection");
        } catch (Exception e){

            System.out.println("fail in connection"+ e.getMessage());
            e.printStackTrace();
        }
    }
}

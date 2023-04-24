package br.com.restaurante.dao;

import br.com.restaurante.model.Reserva;

import java.sql.*;
import java.util.ArrayList;


public class ReservaDao {

    public void createReserva(Reserva reserva) {
        String SQL = "INSERT INTO RESERVAS (DATA, HORA, QNTPESSOAS, AMBIENTE, OBS) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);


            preparedStatement.setString(1, reserva.getData());
            preparedStatement.setString(2, reserva.getHora());
            preparedStatement.setString(3, reserva.getQntPessoas());
            preparedStatement.setString(4, reserva.getAmbiente());
            preparedStatement.setString(5, reserva.getObs());

            preparedStatement.execute();
            connection.close();

            System.out.println("success in connection");
        } catch (Exception e) {

            System.out.println("fail in connection" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static ArrayList<Reserva> listarReservas() {

        ArrayList<Reserva> reservas = new ArrayList<>();

        String SQL = "SELECT * FROM RESERVAS";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String id = rs.getString(1);
                String data = rs.getString(2);
                String hora = rs.getString(3);
                String qntPessoas = rs.getString(4);
                String ambiente = rs.getString(5);
                String obs = rs.getString(6);

                Reserva r = new Reserva();
                reservas.add(r);

                r.setId(id);
                r.setData(data);
                r.setHora(hora);
                r.setQntPessoas(qntPessoas);
                r.setAmbiente(ambiente);
                r.setObs(obs);

            }

            System.out.println("success in select * reservas");

            connection.close();
            return reservas;


        } catch (Exception e) {

            System.out.println(e);
            System.out.println("fail in database connection");

            return null;
        }
    }

}



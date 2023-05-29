package br.com.restaurante.servlet;

import br.com.restaurante.dao.ClientDao;
import br.com.restaurante.model.Client;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



@WebServlet("/esqueceuSenha")
public class EsqueceuSenhaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");

        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa")) {
            ClientDao clientdao = new ClientDao();
            Client client = clientdao.idCliente(email);

            if (client != null) {
                String resetLink = " http://localhost:8080/resetSenha";
                resetEmail(email, resetLink);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("sucesso.html");
    }

    private void resetEmail(String email, String resetLink){

        String to = email;
        String from = "cintiaparafaculdade@gmail.com";// criar uma email para enviar email ao cliente
        String host = "smtp.gmail.com";

        Properties properties = new Properties();

        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "465");
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.smtp.auth","true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("cintiaparafaculdade@gmail.com", "nknkigsdokmfvnak");// inserir suas credencias do email criado para enviar email de redefinição de senha

            }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(to)});
            message.setSubject("Redefinição de Senha");
            message.setText("Olá, você solicitou a recuperação de senha. Clique no link" + resetLink);

            Transport.send(message);


        }catch (MessagingException e){
            e.printStackTrace();
        }


    }
}

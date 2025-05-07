package Trabajo2.notificacion;

import Trabajo2.model.Empleado;
import Trabajo2.model.EnviarNotificacion;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class EnvioDeEmail implements EnviarNotificacion {

    private final String username = "c8a6b699a18312";
    private final String password = "1d18b7e08077af";

    @Override
    public void notificar(Empleado empleado) {

        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
            props.put("mail.smtp.port", "2525");
            props.put("mail.smtp.auth", "true");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                Message mensaje = new MimeMessage(session);
                mensaje.setFrom(new InternetAddress("cumples@empresa.com"));
                mensaje.setRecipients(Message.RecipientType.TO, InternetAddress.parse(empleado.email()));
                mensaje.setSubject("¡Feliz cumpleaños!");
                mensaje.setText("Hola " + empleado.nombre() + " " + empleado.apellido() +
                        ",\n\n¡Feliz cumpleaños!");

                Transport.send(mensaje);
                System.out.println("Enviado a: " + empleado.email());
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
    }
}


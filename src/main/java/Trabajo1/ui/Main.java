package Trabajo1.ui;

import Trabajo1.database.JsbcCargarParticipante;
import Trabajo1.model.Participantes;

import java.awt.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante(new Participantes(new JsbcCargarParticipante(
                            "jdbc:derby:memory:participantes;creare=tue",
                            "app", "app")));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

}

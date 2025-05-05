package Trabajo1.database;

import Trabajo1.model.Participante;
import Trabajo1.model.RegistrarParticipante;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JsbcCargarParticipante implements RegistrarParticipante {

    private final String username;
    private final String pwd;
    private final String url;

    public JsbcCargarParticipante(String username, String pwd, String url) {
        this.username = username;
        this.pwd = pwd;
        this.url = url;

    }

    @Override
    public void registrar(Participante participante) throws SQLException {
        PreparedStatement st = null;
        try (var dbConn = DriverManager.getConnection(url, username, pwd)) {
            st = dbConn.prepareStatement(
                    "INSERT INTO participantes(nombre, telefono, region) VALUES (?, ?, ?)"
            );
            st.setString(1, participante.nombre());
            st.setString(2, participante.numero());
            st.setString(3, participante.region());
            st.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("algo salio mal", e);
        } finally {
            st.close();
        }
    }
}

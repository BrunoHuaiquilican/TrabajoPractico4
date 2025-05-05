package Trabajo1.model;

import java.sql.SQLException;

public class Participantes {

    private RegistrarParticipante registrarParticipante;

    public Participantes(RegistrarParticipante registrarParticipante) {
        this.registrarParticipante = registrarParticipante;
    }

    public void nuevoParticipante(String nombre, String numero, String region) throws SQLException {
        Participante participante = new Participante(nombre, numero, region);
        this.registrarParticipante.registrar(participante);
    }
}

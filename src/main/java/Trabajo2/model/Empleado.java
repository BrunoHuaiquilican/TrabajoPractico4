package Trabajo2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleado {
    private String apellido;
    private String nombre;
    private LocalDate fecha;
    private String email;

    public Empleado(String apellido, String nombre, String fecha, String email) {

        this.apellido = apellido;
        this.nombre = nombre;
        this.fecha = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        this.email = email;
    }

    public boolean cumpleHoy(LocalDate hoy) {
        return this.fecha.getMonth() == hoy.getMonth()
                && this.fecha.getDayOfMonth() == hoy.getDayOfMonth();
    }

    public String apellido() {
        return apellido;
    }

    public String nombre() {
        return nombre;
    }

    public LocalDate fecha() {
        return fecha;
    }

    public String email() {
        return email;
    }
}

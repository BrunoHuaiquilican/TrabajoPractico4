package Trabajo1.model;

import java.util.regex.Pattern;

public class Participante {
    private String nombre;
    private String numero ;
    private String region;
    private static final Pattern FORMATO_TELEFONO = Pattern.compile("\\d{4}-\\d{6}");

    public Participante(String nombre , String numeroTelefono , String region){

        if (nombre().isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (numero().isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un teléfono");
        }
        if (!FORMATO_TELEFONO.matcher(numero()).matches()) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (region().equals("China") && !region().equals("US") && !region().equals("Europa")) {
            throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
        }
        this.nombre = nombre;
        this.numero = numeroTelefono;
        this.region = region ;

    }

    public String nombre(){
        return this.nombre;
    }
    public String numero(){
        return this.numero;
    }
    public String region(){
        return this.region;
    }

}

package Trabajo1.model;

import java.util.regex.Pattern;

public class Participante {
    private static final Pattern FORMATO_TELEFONO = Pattern.compile("\\d{4}-\\d{6}");
    private String nombre;
    private String numero;
    private String region;

    public Participante(String nombre, String numero, String region) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new RuntimeException("Debe cargar un nombre");
        }
        if (numero == null || numero.trim().isEmpty()) {
            throw new RuntimeException("Debe cargar un teléfono");
        }
        if (!FORMATO_TELEFONO.matcher(numero).matches()) {
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (region == null || (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))) {
            throw new RuntimeException("Región desconocida. Las conocidas son: China, US, Europa");
        }

        this.nombre = nombre;
        this.numero = numero;
        this.region = region;
    }

    public String nombre() {
        return this.nombre;
    }

    public String numero() {
        return this.numero;
    }

    public String region() {
        return this.region;
    }

}

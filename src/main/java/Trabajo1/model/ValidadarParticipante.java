package Trabajo1.model;

import java.util.regex.Pattern;

public class ValidadarParticipante {
    private static final Pattern FORMATO_TELEFONO = Pattern.compile("\\d{4}-\\d{6}");

    public static void validar(Participante p) throws IllegalArgumentException {
        if (p.nombre().isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un nombre");
        }
        if (p.numero().isEmpty()) {
            throw new IllegalArgumentException("Debe cargar un teléfono");
        }
        if (!FORMATO_TELEFONO.matcher(p.numero()).matches()) {
            throw new IllegalArgumentException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        if (!p.region().equals("China") && !p.region().equals("US") && !p.region().equals("Europa")) {
            throw new IllegalArgumentException("Región desconocida. Las conocidas son: China, US, Europa");
        }
    }
}

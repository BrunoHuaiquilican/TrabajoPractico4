package Trabajo2.database;

import Trabajo2.model.Empleado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivo {


    public List<Empleado> leer(String archivo) {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("apellido")) continue;

                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    empleados.add(new Empleado(
                            partes[0].trim(),
                            partes[1].trim(),
                            partes[2].trim(),
                            partes[3].trim()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empleados;
    }

}

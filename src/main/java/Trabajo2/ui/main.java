package Trabajo2.ui;

import Trabajo2.database.LectorDeArchivo;
import Trabajo2.model.Empleado;
import Trabajo2.model.ListaEmpleados;
import Trabajo2.notificacion.EnvioDeEmail;

import java.util.List;

public class main {
    public static void main(String[] args) {
        LectorDeArchivo lector = new LectorDeArchivo();
        List<Empleado> empleados = lector.leer("C:/Users/bruno/OneDrive/Escritorio/empleados.txt");

        ListaEmpleados lista = new ListaEmpleados(new EnvioDeEmail());
        lista.notificarCumpleanios(empleados);
    }
}


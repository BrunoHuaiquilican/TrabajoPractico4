package Trabajo2.model;

import java.time.LocalDate;
import java.util.List;

public class ListaEmpleados {
    private EnviarNotificacion enviarNotificacion;

    public ListaEmpleados(EnviarNotificacion enviarNotificacion) {
        this.enviarNotificacion = enviarNotificacion;
    }

    public void notificarCumpleanios(List<Empleado> empleados) {
        LocalDate hoy = LocalDate.now();
        for (Empleado e : empleados) {
            if (e.cumpleHoy(hoy)) {
                enviarNotificacion.notificar(e);
            }
        }
    }
}

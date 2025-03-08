package co.edu.uniquindio.poo.gestionhospital.model;

import java.util.HashMap;

public class GestorConfiguracion {

    private static GestorConfiguracion instancia;
    private String horarioAtencion;
    private String maxPacientesPorMedico;
    private HashMap<String, String> reglasFacturacion;

    /**
     * Método constructor privado para evitar la instanciación directa
     * fuera de esta clase
     */
    private GestorConfiguracion() {
        horarioAtencion = "8:00 a 20:00";
        maxPacientesPorMedico = "5";
        reglasFacturacion = new HashMap<>();

        reglasFacturacion.put("Método de pago", "Se aceptan tarjetas y efectivo.");
        reglasFacturacion.put("Descuento", "10% de descuento para jubilados.");
        reglasFacturacion.put("Multa por cancelación", "20% si cancelas el mismo día.");
    }

    /**
     * Método estático que devuelve la única instancia de la clase gestorConfiguaracion
     * Si la instancia no existe, se crea.
     * @return instancia única del gestor
     */
    public static GestorConfiguracion getInstancia() {
        if (instancia == null) {
            instancia = new GestorConfiguracion();
        }
        return instancia;
    }

    /**
     * Método que muestra la configuración actual
     */
    public void configuracionActual(){
        System.out.println("Horario de atencion: " + horarioAtencion + "\n" +
                           "Maximo de pacientes por medico: " + maxPacientesPorMedico + "\n" +
                           "Reglas de facturacion: "+"\n");
        for (HashMap.Entry<String, String> entry : reglasFacturacion.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue());
        }

    }

    //--------------Getters y Setters de la clase---------------//


    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getMaxPacientesPorMedico() {
        return maxPacientesPorMedico;
    }

    public void setMaxPacientesPorMedico(String maxPacientesPorMedico) {
        this.maxPacientesPorMedico = maxPacientesPorMedico;
    }

    public HashMap<String, String> getReglasFacturacion() {
        return reglasFacturacion;
    }

    public void setReglasFacturacion(HashMap<String, String> reglasFacturacion) {
        this.reglasFacturacion = reglasFacturacion;
    }

}

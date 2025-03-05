package co.edu.uniquindio.poo.gestionhospital.model;

public class gestorConfiguracion {

    private static gestorConfiguracion instancia;
    private String horarioAtencion;
    private String maxPacientesPorMedico;
    private String reglasFacturacion;

    /**
     * Método constructor privado para evitar la instanciación directa
     * fuera de esta clase
     */
    private gestorConfiguracion() {
        horarioAtencion = "8:00 a 20:00";
        maxPacientesPorMedico = "5";
        reglasFacturacion = "ni idea que es esto";
    }

    /**
     * Método estático que devuelve la única instancia de la clase gestorConfiguaracion
     * Si la instancia no existe, se crea.
     * @return instancia única del gestor
     */
    public static gestorConfiguracion getInstancia() {
        if (instancia == null) {
            instancia = new gestorConfiguracion();
        }
        return instancia;
    }

    /**
     * Método que muestra la configuración actual
     */
    public void configuracionActual(){
        System.out.println("Horario de atencion: " + horarioAtencion + "\n" +
                           "Maximo de pacientes por medico: " + maxPacientesPorMedico + "\n" +
                           "Reglas de facturacion: " + reglasFacturacion);
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

    public String getReglasFacturacion() {
        return reglasFacturacion;
    }

    public void setReglasFacturacion(String reglasFacturacion) {
        this.reglasFacturacion = reglasFacturacion;
    }
}

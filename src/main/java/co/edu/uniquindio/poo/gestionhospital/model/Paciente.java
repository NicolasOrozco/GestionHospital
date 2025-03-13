package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

public class Paciente extends Persona {

    private LinkedList<Cita> citas;
    private LocalDate fechaNacimiento;
    private LinkedList<Reporte> historial;

    /**
     * Constructor de Paciente que inicializa su nombre, ID, fecha de nacimiento,
     * lista de citas e historial médico
     *
     * @param nombre          el nombre del paciente
     * @param id              el identificador único del paciente
     * @param fechaNacimiento la fecha de nacimiento del paciente
     */

    public Paciente (String nombre, String id, LocalDate fechaNacimiento) {
        super(nombre, id);
        citas = new LinkedList<>();
        this.fechaNacimiento = fechaNacimiento;
        historial = new LinkedList<>();
    }

    /**
     * Calcula la edad del paciente a partir de su fecha de nacimiento
     *
     * @return la edad del paciente en años
     */

    public int calcularEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    /**
     * Obtiene el primer nombre del paciente sin incluir apellidos
     *
     * @return el primer nombre del paciente en minúsculas
     */
    public String obtenerNombreSinApellido(){
        return getNombre().toLowerCase().split(" ")[0];
    }

    /**
     * Genera una representación en texto del historial médico del paciente
     *
     * @return una cadena con los reportes médicos numerados
     */
    public String obtenerHistorialMedico(){
        int i  =1;
        StringBuilder historialMedico = new StringBuilder();
        historialMedico.append("-------HISTORIAL-MEDICO------");
        for (Reporte reporte : historial) {
            historialMedico.append(reporte.reporteToString(i));
            historialMedico.append("\n");
            i++;
        }
        return historialMedico.toString();
    }

    //--------------Getters y Setters de la clase---------------//

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }

    public LinkedList<Reporte> getHistorial() {
        return historial;
    }

    public void setHistorial(LinkedList<Reporte> historial) {
        this.historial = historial;
    }
}

package co.edu.uniquindio.poo.gestionhospital.model;

public class Cita {

    private String fecha;
    private Paciente paciente;
    private Doctor doctor;

    /**
     * Método constructor de la clase Cita
     * @param fecha Fecha de la cita
     * @param paciente Paciente que asistirá
     * @param doctor Doctor que atenderá
     */
    public Cita(String fecha, Paciente paciente, Doctor doctor) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    //--------------Getters y Setters de la clase---------------//


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}

package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;

public class Cita {

    private LocalDate fecha;
    private Paciente paciente;
    private Doctor doctor;

    /**
     * Constructor de la clase Cita
     *
     * @param fecha Fecha de la cita
     * @param paciente Paciente que asistirá
     * @param doctor Doctor que atenderá
     */
    public Cita(LocalDate fecha, Paciente paciente, Doctor doctor) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.doctor = doctor;
        paciente.getCitas().add(this);
        doctor.getCitas().add(this);
    }

    /**
     * Convierte la información de la cita médica en una cadena de texto formateada
     *
     * @return una cadena que representa la cita médica con la fecha, el paciente y el doctor
     */
    public String citaToString(){
        return "Cita Medica: " +
                "fecha: " + fecha + "\n" +
                "Paciente: " + paciente.getNombre() + "\n" +
                "Doctor: " + doctor.getNombre() + "\n";
    }

    //--------------Getters y Setters de la clase---------------//


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
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

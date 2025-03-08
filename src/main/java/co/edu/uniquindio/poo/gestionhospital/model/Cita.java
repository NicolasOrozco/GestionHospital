package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;

public class Cita {

    private LocalDate fecha;
    private Paciente paciente;
    private Doctor doctor;

    /**
     * Metodo constructor de la clase Cita
     * @param fecha Fecha de la cita
     * @param paciente Paciente que asistirá
     * @param doctor Doctor que atenderá
     */
    public Cita(LocalDate fecha, Paciente paciente, Doctor doctor) {
        this.fecha = fecha;
        this.paciente = paciente;
        this.doctor = doctor;
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

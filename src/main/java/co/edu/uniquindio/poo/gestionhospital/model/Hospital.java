package co.edu.uniquindio.poo.gestionhospital.model;

import java.util.LinkedList;

public class Hospital {

    public String nombre;
    public LinkedList<Doctor> doctores;
    public LinkedList<Paciente> pacientes;
    public LinkedList<Cita> citas;
    protected gestorConfiguracion gestorConfiguracion;

    /**
     * Constructor público de la clase Hospital
     * @param nombre Nombre del hospital
     */
    public Hospital(String nombre) {
        this.nombre = nombre;
        doctores = new LinkedList<>();
        pacientes = new LinkedList<>();
        citas = new LinkedList<>();
        this.gestorConfiguracion = gestorConfiguracion.getInstancia();
    }

    //--------------Getters y Setters de la clase---------------//


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(LinkedList<Doctor> doctores) {
        this.doctores = doctores;
    }

    public LinkedList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(LinkedList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }
}

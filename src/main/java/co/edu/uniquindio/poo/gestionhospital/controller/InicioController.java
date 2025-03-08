package co.edu.uniquindio.poo.gestionhospital.controller;


import co.edu.uniquindio.poo.gestionhospital.model.*;

import java.time.LocalDate;

public class InicioController {
    Hospital hospital;
    public InicioController(Hospital hospital) {
        this.hospital = hospital;
    }
    public Paciente buscarPaciente(String id) {
        return  hospital.buscarPaciente(id);
    }

    public void agregarPaciente(Paciente paciente) {
        hospital.agregarPaciente(paciente);
    }
    public void actualizarPaciente(String id, Paciente paciente) {
        hospital.actualizarPaciente(id, paciente);
    }
    public void eliminarPaciente(String id) {
        hospital.eliminarPaciente(id);
    }
    public Doctor buscarDoctor(String id) {
        return hospital.buscarDoctor(id);
    }
    public void agregarDoctor(Doctor doctor) {
        hospital.agregarDoctor(doctor);
    }
    public void actualizarDoctor(String id, Doctor doctor) {
        hospital.actualizarDoctor(id, doctor);
    }
    public void eliminarDoctor(String id) {
        hospital.eliminarDoctor(id);
    }
    public void agendarCita(LocalDate fecha, Paciente paciente, Doctor doctor){
        hospital.getGestorCitas().agendarCita(fecha,paciente,doctor);
    }
    public boolean cancelarCita(Cita cita){
        return hospital.getGestorCitas().cancelarCita(cita);
    }


}

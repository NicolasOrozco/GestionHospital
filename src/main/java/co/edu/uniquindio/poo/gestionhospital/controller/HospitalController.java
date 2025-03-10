package co.edu.uniquindio.poo.gestionhospital.controller;


import co.edu.uniquindio.poo.gestionhospital.model.*;
import com.sun.source.doctree.DocTree;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

public class HospitalController {
    Hospital hospital;

    public HospitalController(Hospital hospital) {
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
    public Collection<Paciente> obtenerPacientes() {
        return hospital.getPacientes();
    }
    public Collection<Doctor> obtenerDoctores() {
        return hospital.getDoctores();
    }
    public  Collection<Cita> obtenerCitas(){
        return  hospital.getGestorCitas().getCitas();
    }
    public void agendarCita( LocalDate fecha, Paciente paciente, Doctor doctor){
        hospital.getGestorCitas().agendarCita(fecha,paciente,doctor);
    }
    public boolean cancelarCita(Cita cita){
        return hospital.getGestorCitas().cancelarCita(cita);
    }

    public Reporte buscarReporte(LocalDate fechaConsulta, String idPaciente){
        return hospital.buscarReporte(fechaConsulta, idPaciente);
    }
    public void agregarReporteAHistorial(Reporte reporte, String idPaciente) {
        hospital.agregarReporteAHistorial(reporte, idPaciente);
    }
    public void eliminarReporteDelHistorial(LocalDate fechaConsulta, String idPaciente) {
        hospital.eliminarReporteDelHistorial(fechaConsulta, idPaciente);
    }

    //public Reporte clonarReporte(Reporte reporte){
    //    return reporte.clone();
    //}

    public void guardarConfiguracionHospital(String horarioAtencion, String maxPacientesPorMedico, String reglasFacturacion){
        GestorConfiguracion gestor = hospital.getGestorConfiguracion();
        gestor.setHorarioAtencion(horarioAtencion);
        gestor.setMaxPacientesPorMedico(maxPacientesPorMedico);
        //Como editar las reglas de facturacion??
    }

}
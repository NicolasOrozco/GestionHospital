package co.edu.uniquindio.poo.gestionhospital.controller;


import co.edu.uniquindio.poo.gestionhospital.model.*;

import java.time.LocalDate;
import java.util.Collection;

public class HospitalController {
    Hospital hospital;

    public HospitalController(Hospital hospital) {
        this.hospital = hospital;
    }

    //============================LISTAS==========================//
    public Collection<Paciente> obtenerPacientes() {
        return hospital.getPacientes();
    }
    public Collection<Paciente> obtenerPacientesPalindromos(){
        return hospital.obtenerPacientesNombresPalindromos();
    }
    public Collection<Paciente> obtenerPacientesVocalesRepetidas(){
        return hospital.obtenerPacientesNombreDosVocalesIguales();
    }
    public Collection<Doctor> obtenerDoctores() {
        return hospital.getDoctores();
    }
    public Collection<Cita> obtenerCitas(){
        return  hospital.getGestorCitas().getCitas();
    }

    //==========================PACIENTE==========================//
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
    public String verHistorialPaciente(String id) { return hospital.historialPaciente(id);}

    //============================DOCTOR==========================//
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

    //=============================CITA===========================//
    public void agendarCita( LocalDate fecha, Paciente paciente, Doctor doctor){
        hospital.getGestorCitas().agendarCita(fecha,paciente,doctor);
    }
    public boolean cancelarCita(Cita cita){
        return hospital.getGestorCitas().cancelarCita(cita);
    }

    //===========================REPORTE==========================//
    public Reporte buscarReporte(LocalDate fechaConsulta, String idPaciente){
        return hospital.buscarReporte(fechaConsulta, idPaciente);
    }
    public void agregarReporteAHistorial(Reporte reporte, String idPaciente) {
        hospital.agregarReporteAHistorial(reporte, idPaciente);
    }
    public void eliminarReporteDelHistorial(LocalDate fechaConsulta, String idPaciente) {
        hospital.eliminarReporteDelHistorial(fechaConsulta, idPaciente);
    }

     public void clonarReporte(LocalDate fechaConsulta, String idPaciente) {
              Reporte reporteClonado = buscarReporte(fechaConsulta,idPaciente).clonar();
              agregarReporteAHistorial(reporteClonado,idPaciente);
          }


    //=============================EXTRA==========================//




    //=============================EXTRA==========================//




    //======================CONFIGURACION=========================//
    public void guardarConfiguracionHospital(String horarioAtencion, String maxPacientesPorMedico, String reglasFacturacion){
        GestorConfiguracion gestor = hospital.getGestorConfiguracion();
        gestor.setHorarioAtencion(horarioAtencion);
        gestor.setMaxPacientesPorMedico(maxPacientesPorMedico);
        //Como editar las reglas de facturacion??
    }
    public String configuracionActual(){
        return hospital.getGestorConfiguracion().configuracionActualString();
    }

}
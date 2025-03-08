package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Reporte implements Cloneable{
    private LocalDate fechaConsulta;
    private Paciente paciente;
    private Doctor doctor;
    private int edadPacienteEnConsulta;
    private LinkedList<String> enfermedades;
    private LinkedList<String> medicamentos;

    public Reporte(LocalDate fechaConsulta, Paciente paciente, Doctor doctor, LinkedList<String> enfermedades, LinkedList<String> medicamentos) {
        this.fechaConsulta = fechaConsulta;
        this.paciente = paciente;
        this.doctor = doctor;
        this.edadPacienteEnConsulta=paciente.calcularEdad();
        this.enfermedades = new LinkedList<>(enfermedades);
        this.medicamentos = new LinkedList<>(medicamentos);
    }

    public Reporte clone() {
        try {
            Reporte copia = (Reporte) super.clone();

            copia.enfermedades = new LinkedList<>(this.enfermedades);
            copia.medicamentos = new LinkedList<>(this.medicamentos);

            copia.paciente = new Paciente(this.paciente.getNombre(),this.paciente.getId(),this.paciente.getFechaNacimiento());
            copia.doctor = new Doctor(this.doctor.getNombre(),this.doctor.getId(),this.doctor.getEspecialidad());

            copia.edadPacienteEnConsulta = copia.paciente.calcularEdad();

            return copia;
        }catch (CloneNotSupportedException ex) {
            throw new AssertionError();
        }
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }
}

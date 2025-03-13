package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class Reporte implements Cloneable{
    private LocalDate fechaConsulta;
    private Paciente paciente;
    private Doctor doctor;
    private int edadPacienteEnConsulta;
    private LinkedList<String> enfermedades;
    private LinkedList<String> medicamentos;

    /**
     * Constructor de Reporte que inicializa la información de una consulta médica
     *
     * @param fechaConsulta  la fecha en que se realizó la consulta
     * @param paciente       el paciente atendido en la consulta
     * @param doctor         el doctor que realizó la consulta
     * @param enfermedades   la lista de enfermedades diagnosticadas
     * @param medicamentos   la lista de medicamentos recetados
     */
    public Reporte(LocalDate fechaConsulta, Paciente paciente, Doctor doctor, LinkedList<String> enfermedades, LinkedList<String> medicamentos) {
        this.fechaConsulta = fechaConsulta;
        this.paciente = paciente;
        this.doctor = doctor;
        this.edadPacienteEnConsulta=paciente.calcularEdad();
        this.enfermedades = new LinkedList<>(enfermedades);
        this.medicamentos = new LinkedList<>(medicamentos);
    }


    /**
     * Crea una copia del reporte actual incluyendo sus listas de enfermedades y medicamentos,
     * así como copias de los objetos Paciente y Doctor
     *
     * @return una nueva instancia de Reporte idéntica al original
     * @throws RuntimeException si ocurre un error al clonar el objeto
     */
    public Reporte clonar() {
        Reporte copia = null;

        try {
            copia = (Reporte) clone();
            copia.enfermedades = new LinkedList<>(this.enfermedades);
            copia.medicamentos = new LinkedList<>(this.medicamentos);

            copia.paciente = new Paciente(this.paciente.getNombre(),this.paciente.getId(),this.paciente.getFechaNacimiento());
            copia.doctor = new Doctor(this.doctor.getNombre(),this.doctor.getId(),this.doctor.getEspecialidad());

            copia.edadPacienteEnConsulta = copia.paciente.calcularEdad();
            return copia;

        }catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error cloning Reporte");
        }
    }

    /**
     * Genera una representación en texto del reporte médico con el número de consulta
     *
     * @param n el número de reporte dentro del historial del paciente
     * @return una cadena con la información de la consulta, incluyendo fecha, paciente,
     * doctor, edad del paciente, enfermedades y medicamentos
     */
    public String reporteToString(int n) {
        return "----------Reporte-n" + n + "---------\n" +
                "Fecha de consulta: " + fechaConsulta + "\n" +
                "Paciente: " + paciente.getNombre() + "\n" +
                "Doctor: " + doctor.getNombre() + "Especialidad: " + doctor.getEspecialidad() + "\n" +
                "Edad: " + edadPacienteEnConsulta + "\n" +
                "Enfermedades: " + enfermedades + "\n" +
                String.join("\n", enfermedades) + "\n" +
                "Medicamentos: " + medicamentos + "\n" +
                String.join("\n", medicamentos) + "\n" +
                "-----------------------------";
    }

    //-----------------Getters y Setters----------------------//


    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
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

    public int getEdadPacienteEnConsulta() {
        return edadPacienteEnConsulta;
    }

    public void setEdadPacienteEnConsulta(int edadPacienteEnConsulta) {
        this.edadPacienteEnConsulta = edadPacienteEnConsulta;
    }

    public LinkedList<String> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(LinkedList<String> enfermedades) {
        this.enfermedades = enfermedades;
    }

    public LinkedList<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(LinkedList<String> medicamentos) {
        this.medicamentos = medicamentos;
    }
}

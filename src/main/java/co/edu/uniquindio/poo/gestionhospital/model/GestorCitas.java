package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;
import java.util.LinkedList;

public class GestorCitas {
    private static GestorCitas instance;
    private final LinkedList<Cita> citas;

    /**
     * Constructor privado de GestorCitas para implementar el patrón Singleton
     * Inicializa la lista de citas
     */

    private GestorCitas() {
        citas = new LinkedList<>();
    }

    /**
     * Obtiene la instancia única de GestorCitas
     * Si no existe, crea una nueva instancia
     *
     * @return la única instancia de GestorCitas
     */
    public static GestorCitas getInstance() {
        if (instance == null) {
            instance = new GestorCitas();
        }
        return instance;
    }

    /**
     * Agenda una nueva cita médica y la asocia al paciente y al doctor
     *
     * @param fecha    la fecha de la cita
     * @param paciente el paciente que asistirá a la cita
     * @param doctor   el doctor que atenderá la cita
     */
    public void agendarCita(LocalDate fecha, Paciente paciente, Doctor doctor) {
        Cita nuevaCita = new Cita(fecha, paciente, doctor);
        citas.add(nuevaCita);
        paciente.getCitas().add(nuevaCita);
        doctor.getCitas().add(nuevaCita);
    }

    /**
     * Cancela una cita médica eliminándola de la lista de citas
     *
     * @param cita la cita a cancelar
     * @return true si la cita fue eliminada con éxito, false si no se encontró
     */
    public boolean cancelarCita(Cita cita) {
        return citas.remove(cita);
    }

    /**
     * Obtiene la lista de citas registradas
     *
     * @return una nueva lista con las citas registradas para evitar modificaciones externas
     */

    public LinkedList<Cita> getCitas() {
        return new LinkedList<>(citas);
    }
}

package co.edu.uniquindio.poo.gestionhospital.model;

import java.util.LinkedList;

public class Paciente extends Persona {

    private LinkedList<Cita> citas;

    /**
     * Método constructor de la clase Paciente
     * @param nombre Nombre del paciente
     * @param id Número de identificación del paciente
     */
    public Paciente (String nombre, String id){
        super(nombre, id);
        citas = new LinkedList<>();
    }

    //--------------Getters y Setters de la clase---------------//

    public LinkedList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(LinkedList<Cita> citas) {
        this.citas = citas;
    }
}

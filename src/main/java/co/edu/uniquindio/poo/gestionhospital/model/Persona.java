package co.edu.uniquindio.poo.gestionhospital.model;

public class Persona {

    private String nombre;
    private String id;

    /**
     * Constructor de Persona que inicializa su nombre e identificación
     *
     * @param nombre el nombre de la persona
     * @param id     el identificador único de la persona
     */
    public Persona(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    //--------------Getters y Setters de la clase---------------//

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

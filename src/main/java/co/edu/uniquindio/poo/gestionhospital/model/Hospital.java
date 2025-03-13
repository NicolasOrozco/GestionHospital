package co.edu.uniquindio.poo.gestionhospital.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Hospital {

    public String nombre;
    public LinkedList<Doctor> doctores;
    public LinkedList<Paciente> pacientes;
    protected GestorConfiguracion gestorConfiguracion;
    protected GestorCitas gestorCitas;
    private String id;

    /**
     * Constructor de Hospital que inicializa su nombre y gestiona listas de doctores y pacientes
     *
     * @param nombre el nombre del hospital
     */

    public Hospital(String nombre) {
        this.nombre = nombre;
        doctores = new LinkedList<>();
        pacientes = new LinkedList<>();
        this.gestorConfiguracion = gestorConfiguracion.getInstancia();
        this.gestorCitas = gestorCitas.getInstance();
    }

    //---------------------CRUD Paciente-------------------------//

    /**
     * Busca un paciente en la lista de pacientes del hospital por su ID
     *
     * @param id el identificador único del paciente
     * @return el paciente encontrado o null si no existe
     * @throws IllegalArgumentException si el ID es nulo
     */

    public Paciente buscarPaciente(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        for (Paciente paciente : pacientes) {
            if (paciente.getId().equals(id)) {
                return paciente;
            }
        }

        return null;
    }

    /**
     * Agrega un nuevo paciente a la lista del hospital si no está registrado previamente
     *
     * @param paciente el paciente a agregar
     * @throws IllegalArgumentException si el paciente es nulo
     */

    public void agregarPaciente(Paciente paciente) {
        if (paciente == null) {
            throw new IllegalArgumentException("No se ingresó el paciente que se desea agregar.");
        }

        if (buscarPaciente(paciente.getId()) != null) {
            System.out.println("El paciente ya se encuentra registrado.");
            return;
        }

        pacientes.add(paciente);
        System.out.println("Paciente agregado exitosamente.");
    }

    /**
     * Actualiza la información de un paciente existente en el hospital
     *
     * @param id         el identificador del paciente a actualizar
     * @param actualizado el objeto Paciente con los datos actualizados
     * @throws IllegalArgumentException si los datos del paciente actualizado son nulos
     */

    public void actualizarPaciente(String id, Paciente actualizado) {
        if (actualizado == null) {
            throw new IllegalArgumentException("Los datos del paciente actualizado no pueden ser nulos.");
        }

        Paciente paciente = buscarPaciente(id);
        if (paciente != null) {
            paciente.setId(actualizado.getId());
            paciente.setNombre(actualizado.getNombre());
            System.out.println("Paciente actualizado exitosamente.");
        } else {
            System.out.println("No existe un paciente con el id ingresado.");
        }
    }

    /**
     * Elimina un paciente de la lista del hospital si existe
     *
     * @param id el identificador del paciente a eliminar
     * @throws IllegalArgumentException si el ID es nulo
     */

    public void eliminarPaciente(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        Paciente paciente = buscarPaciente(id);
        if (buscarPaciente(id) != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente eliminado exitosamente.");
        } else {
            System.out.println("No existe un paciente con el id ingresado.");
        }
    }

    /**
     * Obtiene el historial médico de un paciente registrado en el hospital
     *
     * @param id el identificador del paciente
     * @return una cadena con el historial médico del paciente
     */

    public String historialPaciente(String id) {
        Paciente paciente = buscarPaciente(id);
        return paciente.obtenerHistorialMedico();

    }

    //----------------------CRUD Doctor-------------------------//

    /**
     * Busca un doctor en la lista de doctores del hospital por su ID
     *
     * @param id el identificador único del doctor
     * @return el doctor encontrado o null si no existe
     * @throws IllegalArgumentException si el ID es nulo
     */

    public Doctor buscarDoctor(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        for (Doctor doctor : doctores) {
            if (doctor.getId().equals(id)) {
                return doctor;
            }
        }

        return null;
    }

    /**
     * Agrega un nuevo doctor a la lista del hospital si no está registrado previamente
     *
     * @param doctor el doctor a agregar
     * @throws IllegalArgumentException si el doctor es nulo
     */

    public void agregarDoctor(Doctor doctor) {
        if (doctor == null) {
            throw new IllegalArgumentException("No se ingresó el doctor que se desea agregar.");
        }

        if (buscarDoctor(doctor.getId()) != null) {
            System.out.println("El doctor ya se encuentra registrado.");
            return;
        }

        doctores.add(doctor);
        System.out.println("Doctor agregado exitosamente.");
    }

    /**
     * Actualiza la información de un doctor existente en el hospital
     *
     * @param id         el identificador del doctor a actualizar
     * @param actualizado el objeto Doctor con los datos actualizados
     * @throws IllegalArgumentException si los datos del doctor actualizado son nulos
     */

    public void actualizarDoctor(String id, Doctor actualizado) {
        if (actualizado == null) {
            throw new IllegalArgumentException("Los datos del doctor actualizado no pueden ser nulos.");
        }

        Doctor doctor = buscarDoctor(id);
        if (buscarDoctor(id) != null) {
            doctor.setId(actualizado.getId());
            doctor.setNombre(actualizado.getNombre());
            System.out.println("Doctor actualizado exitosamente.");
        } else {
            System.out.println("No existe un doctor con el id ingresado.");
        }
    }

    /**
     * Elimina un doctor de la lista del hospital si existe
     *
     * @param id el identificador del doctor a eliminar
     * @throws IllegalArgumentException si el ID es nulo
     */

    public void eliminarDoctor(String id) {
        if (id == null) {
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        Doctor doctor = buscarDoctor(id);
        if (buscarDoctor(id) != null) {
            doctores.remove(doctor);
            System.out.println("Doctor eliminado exitosamente.");
        } else {
            System.out.println("No existe un doctor con el id ingresado.");
        }
    }

    //-------------------------Reporte--------------------------//

    /**
     * Busca un reporte médico en el historial de un paciente por fecha de consulta e ID del paciente
     *
     * @param fechaConsulta la fecha en que se generó el reporte
     * @param idPaciente el identificador del paciente asociado al reporte
     * @return el reporte encontrado
     * @throws IllegalArgumentException si la fecha o el ID del paciente son nulos
     * @throws NoSuchElementException si no se encuentra el paciente o el reporte
     */

    public Reporte buscarReporte(LocalDate fechaConsulta, String idPaciente) {
        if (fechaConsulta == null || idPaciente == null) {
            throw new IllegalArgumentException("No se ingresaron datos para la búsqueda.");
        }

        Paciente pacienteActual = buscarPaciente(idPaciente);
        if (pacienteActual == null) { // Verificamos si el paciente existe
            throw new NoSuchElementException("No se encontró un paciente con el ID proporcionado.");
        }

        for (Reporte reporte : pacienteActual.getHistorial()) {
            if (reporte.getFechaConsulta().equals(fechaConsulta)) {
                return reporte; // Retorna el reporte si se encuentra
            }
        }
        throw new NoSuchElementException("No existe un reporte con la información ingresada.");
    }

    /**
     * Agrega un reporte médico al historial de un paciente
     *
     * @param reporte el reporte a añadir
     * @param idPaciente el identificador del paciente al que se asociará el reporte
     * @throws IllegalArgumentException si el reporte o el paciente son nulos
     */

    public void agregarReporteAHistorial(Reporte reporte, String idPaciente) {
        Paciente paciente = buscarPaciente(idPaciente);
        if(paciente == null || reporte == null) {
            throw new IllegalArgumentException("No se ingresó el paciente o el reporte");
        }
        paciente.getHistorial().add(reporte);
    }

    /**
     * Elimina un reporte del historial de un paciente usando la fecha de consulta y el ID del paciente
     *
     * @param fechaConsulta la fecha en que se generó el reporte
     * @param idPaciente el identificador del paciente asociado al reporte
     * @throws IllegalArgumentException si la fecha o el ID del paciente son nulos
     * @throws NoSuchElementException si no se encuentra el reporte
     */

    public void eliminarReporteDelHistorial(LocalDate fechaConsulta, String idPaciente) {
        if (fechaConsulta == null || idPaciente == null) {
            throw new IllegalArgumentException("No se ingresaron datos para la búsqueda.");
        }

        Reporte reporte = buscarReporte(fechaConsulta, idPaciente);
        reporte.getPaciente().getHistorial().remove(reporte);

    }

    //------------------Métodos adicionales---------------------//

    /**
     * Obtiene una lista de pacientes cuyos nombres sin apellido son palíndromos
     *
     * @return una lista de pacientes con nombres palíndromos
     */

    public LinkedList<Paciente> obtenerPacientesNombresPalindromos(){

        LinkedList<Paciente> palindromos = new LinkedList<>();

        for(Paciente paciente : pacientes){
            if(esPalindromo(paciente.obtenerNombreSinApellido())){
                palindromos.add(paciente);
            }
        }

        return palindromos;

    }

    /**
     * Determina si un nombre es un palíndromo
     *
     * @param nombre el nombre a evaluar
     * @return true si el nombre es un palíndromo, false en caso contrario
     */

    public boolean esPalindromo(String nombre){
        int i = 0;
        int j = nombre.length() - 1;
        while (i <= j) {
            if(nombre.charAt(i) != nombre.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * Obtiene una lista de pacientes cuyos nombres sin apellido contienen al menos dos vocales iguales
     *
     * @return una lista de pacientes con nombres que cumplen la condición
     */

    public LinkedList<Paciente> obtenerPacientesNombreDosVocalesIguales(){

        LinkedList<Paciente> vocalesIguales = new LinkedList<>();

        for(Paciente paciente : pacientes){
            if(nombreDosVocalesIguales(paciente.obtenerNombreSinApellido())){
                vocalesIguales.add(paciente);
            }
        }

        return vocalesIguales;

    }

    /**
     * Determina si un nombre contiene al menos dos vocales iguales
     *
     * @param nombre el nombre a evaluar
     * @return true si el nombre contiene una vocal repetida, false en caso contrario
     */

    public boolean nombreDosVocalesIguales(String nombre){
        nombre = nombre.toLowerCase();
        for (int i = 0; i < nombre.length(); i++) {
            char c = nombre.charAt(i);
            if (esVocal(c)) {
                int cuentaDeLaVocal = 0;
                for (int j = 0; j < nombre.length(); j++) {
                    if (nombre.charAt(j) == c){
                        cuentaDeLaVocal++;
                        }
                    }
                if (cuentaDeLaVocal >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Determina si un carácter es una vocal
     *
     * @param letra el carácter a evaluar
     * @return true si es una vocal, false en caso contrario
     */

    public boolean esVocal(char letra){
        return letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u';
    }

    //----------------------------------------------------------//

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

    public GestorCitas getGestorCitas(){
        return gestorCitas;
    }

    public GestorConfiguracion getGestorConfiguracion(){ return gestorConfiguracion; }

    //----------------------------------------------------------//

}

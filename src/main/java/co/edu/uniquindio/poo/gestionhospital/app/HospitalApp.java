package co.edu.uniquindio.poo.gestionhospital.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.poo.gestionhospital.model.*;

/**
 * Clase principal de la aplicación hospitalaria que extiende Application de JavaFX
 * Se encarga de inicializar la aplicación, cargar datos de prueba y lanzar la interfaz gráfica
 */
public class HospitalApp extends Application {

    public static Hospital hospital = new Hospital("Cosmitet");

    /**
     * Inicializa datos de prueba en el hospital, agregando pacientes y doctores predefinidos
     */
    @Override
    public void init() {

         Paciente paciente = new Paciente("Carlos Valencia", "P-001", LocalDate.of(2000, 1, 1));
         Paciente paciente1 = new Paciente("Ernesto Cortez", "P-002", LocalDate.of(2006, 4, 12));
         Paciente paciente2 = new Paciente("Julia Flores", "P-003", LocalDate.of(1999, 7, 19));
         Paciente paciente3 = new Paciente("Ana Carolina Martinez", "P-004", LocalDate.of(1989, 3, 27));
        Paciente paciente4 = new Paciente("Cristobal Colon", "P-005", LocalDate.of(1960, 2, 27));

         hospital.agregarPaciente(paciente);
         hospital.agregarPaciente(paciente1);
         hospital.agregarPaciente(paciente2);
         hospital.agregarPaciente(paciente3);
         hospital.agregarPaciente(paciente4);

         Doctor doctor = new Doctor("Jorge Eliecer", "D-001", "Cirujano");
         Doctor doctor1 = new Doctor("Patricia Dominguez", "D-002", "Optometra");
         hospital.agregarDoctor(doctor);
         hospital.agregarDoctor(doctor1);



    }

    /**
     * Inicia la aplicación cargando la vista principal de la interfaz gráfica.
     *
     * @param stage el escenario principal de la aplicación
     * @throws IOException si hay un error al cargar la vista FXML
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/HospitalView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Gestión Hospitalaria");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Método principal que inicia la aplicación JavaFX
     *
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}
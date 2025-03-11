package co.edu.uniquindio.poo.gestionhospital.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;

import co.edu.uniquindio.poo.gestionhospital.model.*;
import co.edu.uniquindio.poo.gestionhospital.viewController.*;

public class HospitalApp extends Application {

    public static Hospital hospital = new Hospital("Cosmitet");

    /**
     * Metodo que inicializa datos de prueba en el hospital.
     */
    @Override
    public void init() {

         Paciente paciente = new Paciente("Carlos Valencia", "1234", LocalDate.of(2000, 1, 1));
         Paciente paciente1 = new Paciente("Hernesto Cortez", "5678", LocalDate.of(2006, 4, 12));
         Paciente paciente2 = new Paciente("Julia Flores", "9101", LocalDate.of(1999, 7, 19));
         Paciente paciente3 = new Paciente("Ana", "9102", LocalDate.of(1989, 3, 27));

         hospital.agregarPaciente(paciente);
         hospital.agregarPaciente(paciente1);
         hospital.agregarPaciente(paciente2);
         hospital.agregarPaciente(paciente3);

         Doctor doctor = new Doctor("Jorge Eliecer", "0909", "Cirujano");
         Doctor doctor1 = new Doctor("Patricia Dominguez", "1212", "Optometra");
         hospital.agregarDoctor(doctor);
         hospital.agregarDoctor(doctor1);



    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/views/HospitalView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Gestión Hospitalaria");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
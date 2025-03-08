package co.edu.uniquindio.poo.gestionhospital.viewController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import co.edu.uniquindio.poo.gestionhospital.App;
import co.edu.uniquindio.poo.gestionhospital.model.*;
import co.edu.uniquindio.poo.gestionhospital.controller.InicioController;

import java.time.LocalDate;


public class InicioViewController {
    App app;
    @FXML
    private Button btnCancelarCita;

    @FXML
    private Button btnEditarPaciente;

    @FXML
    private TableColumn<Cita, String> colDoctorCita;

    @FXML
    private TextArea txtFacturacion;

    @FXML
    private TableColumn<Doctor, String> colEspecialidad;

    @FXML
    private Button btnAgregarPaciente;

    @FXML
    private Button btnEditarDoctor;

    @FXML
    private TableColumn<Paciente, Integer> colEdad;

    @FXML
    private TableView<Cita> tablaCitas;

    @FXML
    private Button BtnReservarCita;

    @FXML
    private TableColumn<Paciente, String> colNombre;

    @FXML
    private TableColumn<Paciente, String> colHistorial;

    @FXML
    private TableColumn<Cita, LocalDate> colFechaCita;

    @FXML
    private Button bntEliminarPaciente;

    @FXML
    private TableColumn<Cita, String> colPacienteCita;

    @FXML
    private TextField txtHorario;

    @FXML
    private TableColumn<Cita, String> colNombreDoctor;

    @FXML
    private Button btnAgregarDoctor;

    @FXML
    private TableView<Doctor> tablaDoctores;

    @FXML
    private TableView<Paciente> tablaPacientes;

    @FXML
    private Button btnEliminarDoctor;

    @FXML
    private TextField txtMaxPacientes;

    @FXML
    void agregarPaciente(ActionEvent event) {

    }

    @FXML
    void editarPaciente(ActionEvent event) {

    }

    @FXML
    void eliminarPaciente(ActionEvent event) {

    }

    @FXML
    void agregarDoctor(ActionEvent event) {

    }

    @FXML
    void editarDoctor(ActionEvent event) {

    }

    @FXML
    void eliminarDoctor(ActionEvent event) {

    }

    @FXML
    void reservarCita(ActionEvent event) {

    }

    @FXML
    void cancelarCita(ActionEvent event) {

    }

    @FXML
    void guardarConfiguracion(ActionEvent event) {

    }

    @FXML
    void salir(ActionEvent event) {

    }

    @FXML
    void mostrarPacientes(ActionEvent event) {

    }

    @FXML
    void mostrarDoctores(ActionEvent event) {

    }

    @FXML
    void mostrarCitas(ActionEvent event) {

    }

    @FXML
    void mostrarConfiguracion(ActionEvent event) {

    }

}

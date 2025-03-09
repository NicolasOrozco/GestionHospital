package co.edu.uniquindio.poo.gestionhospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class InicioViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> colDoctorCita;

    @FXML
    private TableColumn<?, ?> colDoctorCita1;

    @FXML
    private TableColumn<?, ?> colEdadPaciente;

    @FXML
    private TableColumn<?, ?> colEspecialidad;

    @FXML
    private TableColumn<?, ?> colFechaCita;

    @FXML
    private TableColumn<?, ?> colFechaCita11;

    @FXML
    private TableColumn<?, ?> colFechaCita111;

    @FXML
    private TableColumn<?, ?> colIdDoctor;

    @FXML
    private TableColumn<?, ?> colIdPaciente;

    @FXML
    private TableColumn<?, ?> colIdPacienteCita;

    @FXML
    private TableColumn<?, ?> colNombreDoctor;

    @FXML
    private TableColumn<?, ?> colNombrePaciente;

    @FXML
    private TableColumn<?, ?> colNombrePacienteCita;

    @FXML
    private TableColumn<?, ?> colPacienteCita1;

    @FXML
    private ComboBox<?> comboDoctorCita;

    @FXML
    private DatePicker dateNacimientoPaciente;

    @FXML
    private TableView<?> tablaCitas;

    @FXML
    private TableView<?> tablaCitas1;

    @FXML
    private TableView<?> tablaDoctores;

    @FXML
    private TableView<?> tablaPacientes;

    @FXML
    private TextField txtEdadPaciente;

    @FXML
    private TextField txtEdadPaciente11;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextArea txtFacturacion;

    @FXML
    private TextField txtHorario;

    @FXML
    private TextField txtIdDoctor;

    @FXML
    private TextField txtIdPacienteCita;

    @FXML
    private Text txtInfoHospital;

    @FXML
    private TextField txtMaxPacientes;

    @FXML
    private TextField txtNombreDoctor;

    @FXML
    private TextField txtNombrePaciente;

    @FXML
    void agendarCita(ActionEvent event) {

    }

    @FXML
    void agregarDoctor(ActionEvent event) {

    }

    @FXML
    void agregarPaciente(ActionEvent event) {

    }

    @FXML
    void agregarReporte(ActionEvent event) {

    }

    @FXML
    void cancelarCi(ActionEvent event) {

    }

    @FXML
    void cancelarCita(ActionEvent event) {

    }

    @FXML
    void dateCita(ActionEvent event) {

    }

    @FXML
    void editarDoctor(ActionEvent event) {

    }

    @FXML
    void editarPaciente(ActionEvent event) {

    }

    @FXML
    void eliminarDoctor(ActionEvent event) {

    }

    @FXML
    void eliminarPaciente(ActionEvent event) {

    }

    @FXML
    void guardarConfiguracion(ActionEvent event) {

    }

    @FXML
    void verCitasPaciente(ActionEvent event) {

    }

    @FXML
    void verHistorialPaciente(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert colDoctorCita != null : "fx:id=\"colDoctorCita\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colDoctorCita1 != null : "fx:id=\"colDoctorCita1\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colEdadPaciente != null : "fx:id=\"colEdadPaciente\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colEspecialidad != null : "fx:id=\"colEspecialidad\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colFechaCita != null : "fx:id=\"colFechaCita\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colFechaCita11 != null : "fx:id=\"colFechaCita11\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colFechaCita111 != null : "fx:id=\"colFechaCita111\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colIdDoctor != null : "fx:id=\"colIdDoctor\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colIdPaciente != null : "fx:id=\"colIdPaciente\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colIdPacienteCita != null : "fx:id=\"colIdPacienteCita\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colNombreDoctor != null : "fx:id=\"colNombreDoctor\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colNombrePaciente != null : "fx:id=\"colNombrePaciente\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colNombrePacienteCita != null : "fx:id=\"colNombrePacienteCita\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert colPacienteCita1 != null : "fx:id=\"colPacienteCita1\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert comboDoctorCita != null : "fx:id=\"comboDoctorCita\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert dateNacimientoPaciente != null : "fx:id=\"dateNacimientoPaciente\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert tablaCitas != null : "fx:id=\"tablaCitas\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert tablaCitas1 != null : "fx:id=\"tablaCitas1\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert tablaDoctores != null : "fx:id=\"tablaDoctores\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert tablaPacientes != null : "fx:id=\"tablaPacientes\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtEdadPaciente != null : "fx:id=\"txtEdadPaciente\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtEdadPaciente11 != null : "fx:id=\"txtEdadPaciente11\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtEspecialidad != null : "fx:id=\"txtEspecialidad\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtFacturacion != null : "fx:id=\"txtFacturacion\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtHorario != null : "fx:id=\"txtHorario\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtIdDoctor != null : "fx:id=\"txtIdDoctor\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtIdPacienteCita != null : "fx:id=\"txtIdPacienteCita\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtInfoHospital != null : "fx:id=\"txtInfoHospital\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtMaxPacientes != null : "fx:id=\"txtMaxPacientes\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtNombreDoctor != null : "fx:id=\"txtNombreDoctor\" was not injected: check your FXML file 'Inicio.fxml'.";
        assert txtNombrePaciente != null : "fx:id=\"txtNombrePaciente\" was not injected: check your FXML file 'Inicio.fxml'.";

    }

}

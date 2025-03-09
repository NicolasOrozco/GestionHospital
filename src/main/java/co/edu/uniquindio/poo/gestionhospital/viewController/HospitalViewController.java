package co.edu.uniquindio.poo.gestionhospital.viewController;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestionhospital.controller.HospitalController;
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

public class HospitalViewController {

    public HospitalController hospitalController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> colDoctorCita;

    @FXML
    private TableColumn<?, ?> colDoctorEspecialidad;

    @FXML
    private TableColumn<?, ?> colDoctorId;

    @FXML
    private TableColumn<?, ?> colDoctorNombre;

    @FXML
    private TableColumn<?, ?> colFechaCita;

    @FXML
    private TableColumn<?, ?> colIdPacienteCita;

    @FXML
    private TableColumn<?, ?> colNombrePacienteCita;

    @FXML
    private TableColumn<?, ?> colPacienteEdad;

    @FXML
    private TableColumn<?, ?> colPacienteId;

    @FXML
    private TableColumn<?, ?> colPacienteNombre;

    @FXML
    private ComboBox<?> comboBoxCitaDoctor;

    @FXML
    private DatePicker dateCita;

    @FXML
    private DatePicker dateEliminarClonarReporte;

    @FXML
    private DatePicker dateFechaReporte;

    @FXML
    private DatePicker datePacienteNacimiento;

    @FXML
    private TableView<?> tablaCitas;

    @FXML
    private TableView<?> tablaDoctores;

    @FXML
    private TableView<?> tablaPacientes;

    @FXML
    private TextField txtCitaPacienteId;

    @FXML
    private TextField txtDoctorEspecialidad;

    @FXML
    private TextField txtDoctorId;

    @FXML
    private TextField txtDoctorNombre;

    @FXML
    private TextArea txtEnfermedadesReportes;

    @FXML
    private TextField txtHorarioAtencion;

    @FXML
    private TextField txtIdBuscarDoctor;

    @FXML
    private TextField txtIdDoctorReporte;

    @FXML
    private TextField txtIdPacienteBuscar;

    @FXML
    private TextField txtIdPacienteEliminarClonar;

    @FXML
    private TextField txtIdPacienteReporte;

    @FXML
    private Text txtInfoHospital;

    @FXML
    private TextField txtMaxPacientes;

    @FXML
    private TextArea txtMedicamentosReportes;

    @FXML
    private TextField txtNombrePaciente;

    @FXML
    private TextField txtPacienteId;

    @FXML
    private TextArea txtReglasFacturacion;

    @FXML
    void onAgendarCita(ActionEvent event) {

    }

    @FXML
    void onAgregarDoctor(ActionEvent event) {

    }

    @FXML
    void onAgregarPaciente(ActionEvent event) {

    }

    @FXML
    void onAgregarReporte(ActionEvent event) {

    }

    @FXML
    void onBuscarDoctor(ActionEvent event) {

    }

    @FXML
    void onBuscarPaciente(ActionEvent event) {

    }

    @FXML
    void onCancelarCita(ActionEvent event) {

    }

    @FXML
    void onCitaDoctor(ActionEvent event) {

    }

    @FXML
    void onClonarReporte(ActionEvent event) {

    }

    @FXML
    void onEditarDoctor(ActionEvent event) {

    }

    @FXML
    void onEditarPaciente(ActionEvent event) {

    }

    @FXML
    void onEliminarDoctor(ActionEvent event) {

    }

    @FXML
    void onEliminarPaciente(ActionEvent event) {

    }

    @FXML
    void onEliminarReporte(ActionEvent event) {

    }

    @FXML
    void onFechaReporte(ActionEvent event) {

    }

    @FXML
    void onGuardarConfiguracion(ActionEvent event) {

    }

    @FXML
    void onVerCitasEHistorialPaciente(ActionEvent event) {

    }

    //=====================OTRO=====================//
    public LinkedList<String> convertirStringALista(String texto) {

        LinkedList<String> listaStrings = new LinkedList<>();

        if (texto != null && !texto.isEmpty()) {
            String[] textoArray = texto.split(";");
            //se añaden las listas a la LinkedList
            for (String s : textoArray) {
                listaStrings.add(s.trim());//trim es para eliminar espacios en blancos
            }
        }
        return listaStrings;
    }

    @FXML
    void initialize() {
        assert colDoctorCita != null : "fx:id=\"colDoctorCita\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colDoctorEspecialidad != null : "fx:id=\"colDoctorEspecialidad\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colDoctorId != null : "fx:id=\"colDoctorId\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colDoctorNombre != null : "fx:id=\"colDoctorNombre\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colFechaCita != null : "fx:id=\"colFechaCita\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colIdPacienteCita != null : "fx:id=\"colIdPacienteCita\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colNombrePacienteCita != null : "fx:id=\"colNombrePacienteCita\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colPacienteEdad != null : "fx:id=\"colPacienteEdad\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colPacienteId != null : "fx:id=\"colPacienteId\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert colPacienteNombre != null : "fx:id=\"colPacienteNombre\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert comboBoxCitaDoctor != null : "fx:id=\"comboBoxCitaDoctor\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert dateCita != null : "fx:id=\"dateCita\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert dateEliminarClonarReporte != null : "fx:id=\"dateEliminarClonarReporte\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert dateFechaReporte != null : "fx:id=\"dateFechaReporte\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert datePacienteNacimiento != null : "fx:id=\"datePacienteNacimiento\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert tablaCitas != null : "fx:id=\"tablaCitas\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert tablaDoctores != null : "fx:id=\"tablaDoctores\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert tablaPacientes != null : "fx:id=\"tablaPacientes\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtCitaPacienteId != null : "fx:id=\"txtCitaPacienteId\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtDoctorEspecialidad != null : "fx:id=\"txtDoctorEspecialidad\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtDoctorId != null : "fx:id=\"txtDoctorId\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtDoctorNombre != null : "fx:id=\"txtDoctorNombre\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtEnfermedadesReportes != null : "fx:id=\"txtEnfermedadesReportes\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtHorarioAtencion != null : "fx:id=\"txtHorarioAtencion\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtIdBuscarDoctor != null : "fx:id=\"txtIdBuscarDoctor\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtIdDoctorReporte != null : "fx:id=\"txtIdDoctorReporte\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtIdPacienteBuscar != null : "fx:id=\"txtIdPacienteBuscar\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtIdPacienteEliminarClonar != null : "fx:id=\"txtIdPacienteEliminarClonar\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtIdPacienteReporte != null : "fx:id=\"txtIdPacienteReporte\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtInfoHospital != null : "fx:id=\"txtInfoHospital\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtMaxPacientes != null : "fx:id=\"txtMaxPacientes\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtMedicamentosReportes != null : "fx:id=\"txtMedicamentosReportes\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtNombrePaciente != null : "fx:id=\"txtNombrePaciente\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtPacienteId != null : "fx:id=\"txtPacienteId\" was not injected: check your FXML file 'HospitalView.fxml'.";
        assert txtReglasFacturacion != null : "fx:id=\"txtReglasFacturacion\" was not injected: check your FXML file 'HospitalView.fxml'.";

    }

}

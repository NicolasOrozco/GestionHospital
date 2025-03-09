package co.edu.uniquindio.poo.gestionhospital.viewController;
import co.edu.uniquindio.poo.gestionhospital.controller.InicioController;
import co.edu.uniquindio.poo.gestionhospital.model.Paciente;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import co.edu.uniquindio.poo.gestionhospital.model.*;
import java.time.LocalDate;
import java.util.LinkedList;
import co.edu.uniquindio.poo.gestionhospital.App;
import javafx.event.ActionEvent;


public class InicioViewController {

    App app;
    private InicioController inicioController;

    // Pacientes
    @FXML private Button btnAgregarPaciente;
    @FXML private Button btnEditarPaciente;
    @FXML private Button btnEliminarPaciente;
    @FXML private Button btnVerCitasPaciente;
    @FXML private Button btnVerHistorialPaciente;
    @FXML private TextField txtPacienteNombre;
    @FXML private TextField txtPacienteId;
    @FXML private DatePicker datePickerPacienteNacimiento;
    @FXML private TableView<?> tablaPacientes;
    @FXML private TableColumn<?, ?> colPacienteId;
    @FXML private TableColumn<?, ?> colPacienteNombre;
    @FXML private TableColumn<?, ?> colPacienteEdad;

    // Doctores
    @FXML private Button btnAgregarDoctor;
    @FXML private Button btnEditarDoctor;
    @FXML private Button btnEliminarDoctor;
    @FXML private TextField txtDoctorNombre;
    @FXML private TextField txtDoctorId;
    @FXML private TextField txtDoctorEspecialidad;
    @FXML private TableView<?> tablaDoctores;
    @FXML private TableColumn<?, ?> colDoctorId;
    @FXML private TableColumn<?, ?> colDoctorNombre;
    @FXML private TableColumn<?, ?> colDoctorEspecialidad;

    // Citas
    @FXML private Button btnAgendarCita;
    @FXML private Button btnCancelarCita;
    @FXML private DatePicker datePickerCita;
    @FXML private TextField txtCitaPacienteId;
    @FXML private ComboBox<?> comboBoxCitaDoctor;
    @FXML private TableView<?> tablaCitas;
    @FXML private TableColumn<?, ?> colFechaCita;
    @FXML private TableColumn<?, ?> colIdPacienteCita;
    @FXML private TableColumn<?, ?> colNombrePacienteCita;
    @FXML private TableColumn<?, ?> colDoctorCita;

    // Reportes
    @FXML private Button btnAgregarReporte;
    @FXML private Button btnEliminarReporte;
    @FXML private Button btnVerDetallesReporte;
    @FXML private Button btnClonarReporte;
    @FXML private DatePicker datePickerReporteConsulta;
    @FXML private TextField txtPacienteReporte;
    @FXML private ComboBox<?> comboBoxReporteDoctor;
    @FXML private TableView<?> tablaReportes;
    @FXML private TableColumn<?, ?> colReporteFecha;
    @FXML private TableColumn<?, ?> colReportePacienteId;
    @FXML private TableColumn<?, ?> colReportePacienteNombre;
    @FXML private TableColumn<?, ?> colReporteDoctor;

    // Configuración
    @FXML private TextField txtHorarioAtencion;
    @FXML private TextField txtMaxPacientes;
    @FXML private TextArea txtReglasFacturacion;
    @FXML private Button btnGuardarConfiguracion;
    @FXML private Text txtInfoHospital;

    //=====================PACIENTES=====================//
    public Paciente buildPaciente() {
        return new Paciente(txtPacienteNombre.getText(), txtPacienteId.getText(), dateNacimientoPaciente.getValue());
    }

    @FXML
    void agregarPaciente(ActionEvent event) {
        Paciente paciente = buildPaciente();
        inicioController.agregarPaciente(paciente);
    }

    @FXML
    void editarPaciente(ActionEvent event) {


    }

    @FXML
    void eliminarPaciente(ActionEvent event) {

    }
    @FXML
    void verCitasPaciente(ActionEvent event) {

    }

    @FXML
    void verHistorialPaciente(ActionEvent event) {


    }

    //=====================DOCTOR=====================//

    @FXML
    void agregarDoctor(ActionEvent event) {

    }

    @FXML
    void editarDoctor(ActionEvent event) {

    }

    @FXML
    void eliminarDoctor(ActionEvent event) {

    }

    //=====================CITA=====================//

    @FXML
    void dateCita(ActionEvent event) {

    }

    @FXML
    void agendarCita(ActionEvent event) {

    }

    @FXML
    void cancelarCita(ActionEvent event) {

    }

    //=====================REPORTES=====================//

    @FXML
    void onVerDetallesReporte(ActionEvent event) {

    }

    @FXML
    void agregarReporte(ActionEvent event) {

    }

    @FXML
    void onEliminarReporte(ActionEvent event) {

    }
    //=====================CONFIGURACION=====================//
    @FXML
    void guardarConfiguracion(ActionEvent event) {

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

    public void setApp(App app){
            this.app = app;
    }

}

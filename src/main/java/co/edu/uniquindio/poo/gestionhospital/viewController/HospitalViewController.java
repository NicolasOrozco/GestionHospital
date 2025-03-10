package co.edu.uniquindio.poo.gestionhospital.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestionhospital.controller.HospitalController;
import co.edu.uniquindio.poo.gestionhospital.model.*;
import co.edu.uniquindio.poo.gestionhospital.App;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ObservableList<Doctor> listDoctores = FXCollections.observableArrayList();
    private ObservableList<Paciente> listPacientes = FXCollections.observableArrayList();
    private ObservableList<Cita> listCitas = FXCollections.observableArrayList();
    private Doctor selectedDoctor;
    private Paciente selectedPaciente;
    private Cita selectedCita;


    public App app;
    public HospitalController hospitalController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Cita, String> colDoctorCita;

    @FXML
    private TableColumn<Doctor, String> colDoctorEspecialidad;

    @FXML
    private TableColumn<Doctor, String> colDoctorId;

    @FXML
    private TableColumn<Doctor, String> colDoctorNombre;

    @FXML
    private TableColumn<Cita, LocalDate> colFechaCita;

    @FXML
    private TableColumn<Cita, String> colIdPacienteCita;

    @FXML
    private TableColumn<Cita, String> colNombrePacienteCita;

    @FXML
    private TableColumn<Paciente, Integer> colPacienteEdad;

    @FXML
    private TableColumn<Paciente, String> colPacienteId;

    @FXML
    private TableColumn<Paciente, String> colPacienteNombre;

    @FXML
    private ComboBox<Doctor> comboBoxCitaDoctor;

    @FXML
    private DatePicker dateCita;

    @FXML
    private DatePicker dateEliminarClonarReporte;

    @FXML
    private DatePicker dateFechaReporte;

    @FXML
    private DatePicker datePacienteNacimiento;

    @FXML
    private TableView<Cita> tablaCitas;

    @FXML
    private TableView<Doctor> tablaDoctores;

    @FXML
    private TableView<Paciente> tablaPacientes;

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
        hospitalController.agendarCita(dateCita.getValue(), hospitalController.buscarPaciente(txtCitaPacienteId.getText()), onCitaDoctor()); //!!!! Tener en cuenta
        initDataBinding();
    }

    @FXML
    void onAgregarDoctor(ActionEvent event) {
        hospitalController.agregarDoctor(new Doctor(txtDoctorNombre.getText(),txtDoctorId.getText(), txtDoctorEspecialidad.getText()));
        initDataBinding();
    }

    @FXML
    void onAgregarPaciente(ActionEvent event) {
        hospitalController.agregarPaciente(new Paciente(txtNombrePaciente.getText(), txtPacienteId.getText(), datePacienteNacimiento.getValue()));
        initDataBinding();
    }

    @FXML
    void onAgregarReporte(ActionEvent event) {
        hospitalController.agregarReporteAHistorial(hospitalController.buscarReporte(dateFechaReporte.getValue(), txtIdPacienteReporte.getText()), txtIdPacienteReporte.getText());
        initDataBinding();
    }

    @FXML
    void onBuscarDoctor(ActionEvent event) {
        hospitalController.buscarDoctor(txtIdBuscarDoctor.getText());
    }

    @FXML
    void onBuscarPaciente(ActionEvent event) {
        hospitalController.buscarPaciente(txtIdPacienteBuscar.getText());
    }

    @FXML
    void onCancelarCita(ActionEvent event) {
        hospitalController.cancelarCita();//////// Mas tarde
        initDataBinding();
    }

    @FXML
    Doctor onCitaDoctor() {
        return comboBoxCitaDoctor.getValue(); // Tener en cuenta
    }

    @FXML
    void onClonarReporte(ActionEvent event) {
        //hospitalController.clonarReporte()
    }

    @FXML
    void onEditarDoctor(ActionEvent event) {

    }

    @FXML
    void onEditarPaciente(ActionEvent event) {
        hospitalController.actualizarPaciente(
                
        );
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
    void onGuardarConfiguracion(ActionEvent event) {
        hospitalController.guardarConfiguracionHospital(txtHorarioAtencion.getText(), txtMaxPacientes.getText(), txtReglasFacturacion.getText());
        initDataBinding();
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
        hospitalController = new HospitalController(app.hospital);
        initView();
    }

    private void initView(){
        initDataBinding();
        cargarPacientes();
        cargarDoctores();
        cargarCitas();
        tablaCitas.setItems(listCitas);
        tablaDoctores.setItems(listDoctores);
        tablaPacientes.setItems(listPacientes);
        listenerSelection();
    }
    private void listenerSelection()
    {
        tablaPacientes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedPaciente = newSelection;
        });
        tablaDoctores.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedDoctor = newSelection;
        });
        tablaCitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectedCita = newSelection;
        });
    }
    public void cargarPacientes(){
        Collection<Paciente> pacientes = hospitalController.obtenerPacientes();
        listPacientes.setAll(pacientes);
    }
    public void cargarDoctores(){
        Collection<Doctor> doctores = hospitalController.obtenerDoctores();
        listDoctores.setAll(doctores);
    }
    public void cargarCitas(){
        Collection<Cita> citas = hospitalController.obtenerCitas();
        listCitas.setAll(citas);
    }

    private void initDataBinding() {
        // Enlaces para la tabla de pacientes
        colPacienteId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colPacienteNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colPacienteEdad.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().calcularEdad()));

        // Enlaces para la tabla de doctores
        colDoctorId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        colDoctorNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colDoctorEspecialidad.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEspecialidad()));

        // Enlaces para la tabla de citas
        colFechaCita.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getFecha()));
        colIdPacienteCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaciente().getId()));
        colNombrePacienteCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPaciente().getNombre()));
        colDoctorCita.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDoctor().getNombre()));

        // Puedes agregar más enlaces para otros controles según sea necesario
    }
    public void setApp(App app){
        this.app = app;
    }
}

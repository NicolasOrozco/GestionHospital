package co.edu.uniquindio.poo.gestionhospital.viewController;

import java.net.URL;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.gestionhospital.controller.HospitalController;
import co.edu.uniquindio.poo.gestionhospital.model.*;
import co.edu.uniquindio.poo.gestionhospital.app.App;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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


    //==========================PACIENTE==========================//
    @FXML
    private TableColumn<Paciente, Integer> colPacienteEdad;
    @FXML
    private TableColumn<Paciente, String> colPacienteId;
    @FXML
    private TableColumn<Paciente, String> colPacienteNombre;
    @FXML
    private DatePicker datePacienteNacimiento;
    @FXML
    private TableView<Paciente> tablaPacientes;
    @FXML
    private TextField txtCitaPacienteId;
    @FXML
    private TextField txtIdPacienteBuscar;
    @FXML
    private TextField txtNombrePaciente;
    @FXML
    private TextField txtPacienteId;

    //============================DOCTOR==========================//
    @FXML
    private TableColumn<Doctor, String> colDoctorEspecialidad;
    @FXML
    private TableColumn<Doctor, String> colDoctorId;
    @FXML
    private TableColumn<Doctor, String> colDoctorNombre;
    @FXML
    private TableView<Doctor> tablaDoctores;
    @FXML
    private TextField txtDoctorEspecialidad;
    @FXML
    private TextField txtDoctorId;
    @FXML
    private TextField txtDoctorNombre;
    @FXML
    private TextField txtIdBuscarDoctor;

    //=============================CITA===========================//
    @FXML
    private TableColumn<Cita, String> colDoctorCita;
    @FXML
    private TableColumn<Cita, LocalDate> colFechaCita;
    @FXML
    private TableColumn<Cita, String> colIdPacienteCita;
    @FXML
    private TableColumn<Cita, String> colNombrePacienteCita;
    @FXML
    private TextField txtCitaDoctorId;
    @FXML
    private DatePicker dateCita;
    @FXML
    private TableView<Cita> tablaCitas;

    //===========================REPORTE==========================//
    @FXML
    private DatePicker dateFechaReporte;
    @FXML
    private TextField txtIdDoctorReporte;
    @FXML
    private TextField txtIdPacienteReporte;
    @FXML
    private TextArea txtEnfermedadesReportes;
    @FXML
    private TextArea txtMedicamentosReportes;
    @FXML
    private TextField txtIdPacienteEliminarClonar;
    @FXML
    public DatePicker dateEliminarClonarReporte;


    //======================CONFIGURACION=========================//
    @FXML
    private Text txtInfoHospital;
    @FXML
    private TextField txtHorarioAtencion;
    @FXML
    private TextField txtMaxPacientes;
    @FXML
    private TextArea txtReglasFacturacion;


    //METODOS:

    //============================LISTAS BUILDS==========================//
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

    public Paciente buildPaciente() {
        return new Paciente(txtNombrePaciente.getText(), txtPacienteId.getText(), datePacienteNacimiento.getValue());
    }
    public Doctor buildDoctor() {
        return new Doctor(txtDoctorNombre.getText(), txtDoctorId.getText(), txtDoctorEspecialidad.getText());
    }

    //==========================PACIENTE==========================//

    @FXML
    void onBuscarPaciente(ActionEvent event) {
        String idBuscar = txtIdPacienteBuscar.getText();
        if(!idBuscar.isEmpty()){
            Paciente pacienteEncontrado = hospitalController.buscarPaciente(idBuscar);
            if(pacienteEncontrado != null){
                tablaPacientes.getSelectionModel().select(pacienteEncontrado);
                tablaPacientes.scrollTo(pacienteEncontrado);
            }
        }
    }

    @FXML
    void onAgregarPaciente(ActionEvent event) {
        hospitalController.agregarPaciente(buildPaciente());
        initDataBinding();
    }

    @FXML
    void onEditarPaciente(ActionEvent event) {
        Paciente pacienteSeleccionado = selectedPaciente;
        Paciente pacienteActual = buildPaciente();
        if (pacienteSeleccionado != null) {
            hospitalController.actualizarPaciente(pacienteSeleccionado.getId(), pacienteActual);
            cargarPacientes();
        }
    }

    @FXML
    void onVerCitasEHistorialPaciente(ActionEvent event) {

    }

    @FXML
    void onEliminarPaciente(ActionEvent event) {
        Paciente pacienteSeleccionado = selectedPaciente;
        if(pacienteSeleccionado != null){
            hospitalController.eliminarPaciente(pacienteSeleccionado.getId());
            cargarPacientes();
        }
    }

    //===========================DOCTOR===========================//

    @FXML
    void onBuscarDoctor(ActionEvent event) {
        String idBuscar = txtIdBuscarDoctor.getText();
        if(!idBuscar.isEmpty()){
            Doctor doctorEncontrado = hospitalController.buscarDoctor(idBuscar);
            if(doctorEncontrado != null){
                tablaDoctores.getSelectionModel().select(doctorEncontrado);
                tablaDoctores.scrollTo(doctorEncontrado);
            }
        }
    }
    @FXML
    void onAgregarDoctor(ActionEvent event) {
        hospitalController.agregarDoctor(buildDoctor());
        initDataBinding();
    }

    @FXML
    void onEditarDoctor(ActionEvent event) {
        Doctor doctorSeleccionado = selectedDoctor;
        Doctor doctorActual = buildDoctor();
        if (doctorSeleccionado != null) {
            hospitalController.actualizarDoctor(doctorSeleccionado.getId(), doctorActual);
            cargarDoctores();
        }
    }

    @FXML
    void onEliminarDoctor(ActionEvent event) {
        Doctor doctorSeleccionado = selectedDoctor;
        if(doctorSeleccionado != null){
            hospitalController.eliminarDoctor(doctorSeleccionado.getId());
            cargarDoctores();
        }

    }

    //============================CITA============================//

    @FXML
    void onAgendarCita(ActionEvent event) {
        hospitalController.agendarCita(dateCita.getValue(), hospitalController.buscarPaciente(txtCitaPacienteId.getText()), hospitalController.buscarDoctor(txtDoctorId.getText()));
        initDataBinding();
    }
    @FXML
    void onCancelarCita(ActionEvent event) {
        Cita citaSeleccionada = selectedCita;
        hospitalController.cancelarCita(citaSeleccionada);
        initDataBinding();
    }


    //===========================REPORTE==========================//

    @FXML
    void onAgregarReporte(ActionEvent event) {
        hospitalController.agregarReporteAHistorial(hospitalController.buscarReporte(dateFechaReporte.getValue(), txtIdPacienteReporte.getText()), txtIdPacienteReporte.getText());
        initDataBinding();
    }

    @FXML
    void onEliminarReporte(ActionEvent event) {

    }

    @FXML
    void onClonarReporte(ActionEvent event) {
        //hospitalController.clonarReporte()
    }

    @FXML
    public void onFechaReporte(ActionEvent actionEvent) {
    }

    //========================CONFIGURACION=======================//

    @FXML
    void onGuardarConfiguracion(ActionEvent event) {
        hospitalController.guardarConfiguracionHospital(txtHorarioAtencion.getText(), txtMaxPacientes.getText(), txtReglasFacturacion.getText());
        initDataBinding();
    }
    //mostrar config

    //=====================OTRO=====================//

    /**
     * Metodo para convertir una String a una lista de strings cortandolo desde un ";"
     * @param texto String dividida de ";"
     * @return Lista de Strings
     */
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
            if( newSelection != null){
                selectedPaciente = newSelection;
                txtNombrePaciente.setText(newSelection.getNombre());
                txtPacienteId.setText(newSelection.getId());
                datePacienteNacimiento.setValue(newSelection.getFechaNacimiento());
            }
        });
        tablaDoctores.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if( newSelection != null){
                selectedDoctor = newSelection;
                txtDoctorNombre.setText(newSelection.getNombre());
                txtDoctorId.setText(newSelection.getId());
                txtDoctorEspecialidad.setText(newSelection.getEspecialidad());
            }
        });
        tablaCitas.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if( newSelection != null){
                selectedCita = newSelection;
                dateCita.setValue(newSelection.getFecha());
                txtCitaPacienteId.setText(newSelection.getPaciente().getId());
                txtCitaDoctorId.setText(newSelection.getDoctor().getId());
            }
        });
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

package co.edu.uniquindio.poo.gestionhospital.viewController;

import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;

import co.edu.uniquindio.poo.gestionhospital.controller.HospitalController;
import co.edu.uniquindio.poo.gestionhospital.model.*;
import co.edu.uniquindio.poo.gestionhospital.app.HospitalApp;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.swing.*;

public class HospitalViewController {
    private final ObservableList<Doctor> listDoctores = FXCollections.observableArrayList();
    private final ObservableList<Paciente> listPacientes = FXCollections.observableArrayList();
    private final ObservableList<Cita> listCitas = FXCollections.observableArrayList();
    private Doctor selectedDoctor;
    private Paciente selectedPaciente;
    private Cita selectedCita;

    public HospitalApp HospitalApp;
    public HospitalController hospitalController;


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
    public void cargarPacientesPalindromos(){
        Collection<Paciente> pacientesPalindromos = hospitalController.obtenerPacientesPalindromos();
        listPacientes.setAll(pacientesPalindromos);
    }
    public void cargarPacientesVocalesRepetidas(){
        Collection<Paciente> pacientesVocalesRepetidas = hospitalController.obtenerPacientesVocalesRepetidas();
        listPacientes.setAll(pacientesVocalesRepetidas);
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
    public Reporte buildReporte() {
        return new Reporte(dateFechaReporte.getValue(), hospitalController.buscarPaciente(txtIdPacienteReporte.getText()),
                hospitalController.buscarDoctor(txtIdDoctorReporte.getText()), convertirStringALista(txtEnfermedadesReportes.getText()),
                convertirStringALista(txtMedicamentosReportes.getText()));
    }


    //==========================PACIENTE==========================//

    @FXML
    void onBuscarPaciente() {
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
    void onAgregarPaciente() {
        hospitalController.agregarPaciente(buildPaciente());
        cargarPacientes();
    }

    @FXML
    void onEditarPaciente() {
        Paciente pacienteSeleccionado = selectedPaciente;
        Paciente pacienteActual = buildPaciente();
        if (pacienteSeleccionado != null) {
            hospitalController.actualizarPaciente(pacienteSeleccionado.getId(), pacienteActual);
            cargarPacientes();
        }
    }

    @FXML
    void onVerCitasEHistorialPaciente() {
        String id = txtPacienteId.getText();
        String historial = hospitalController.verHistorialPaciente(id);

        JFrame frame = new JFrame("Historial del paciente");
        JTextArea textArea = new JTextArea(20,50);
        textArea.setText(historial);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.setSize(600,400);
        frame.add(scrollPane);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @FXML
    void onEliminarPaciente() {
        Paciente pacienteSeleccionado = selectedPaciente;
        if(pacienteSeleccionado != null){
            hospitalController.eliminarPaciente(pacienteSeleccionado.getId());
            cargarPacientes();
        }
    }

    //===========================DOCTOR===========================//

    @FXML
    void onBuscarDoctor() {
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
    void onAgregarDoctor() {
        hospitalController.agregarDoctor(buildDoctor());
        cargarDoctores();
    }

    @FXML
    void onEditarDoctor() {
        Doctor doctorSeleccionado = selectedDoctor;
        Doctor doctorActual = buildDoctor();
        if (doctorSeleccionado != null) {
            hospitalController.actualizarDoctor(doctorSeleccionado.getId(), doctorActual);
            cargarDoctores();
        }
    }

    @FXML
    void onEliminarDoctor() {
        Doctor doctorSeleccionado = selectedDoctor;
        if(doctorSeleccionado != null){
            hospitalController.eliminarDoctor(doctorSeleccionado.getId());
            cargarDoctores();
        }

    }

    //============================CITA============================//

    @FXML
    void onAgendarCita() {
        hospitalController.agendarCita(dateCita.getValue(), hospitalController.buscarPaciente(txtCitaPacienteId.getText()), hospitalController.buscarDoctor(txtCitaDoctorId.getText()));
        cargarCitas();
    }
    @FXML
    void onCancelarCita() {
        Cita citaSeleccionada = selectedCita;
        hospitalController.cancelarCita(citaSeleccionada);
        cargarCitas();
    }


    //===========================REPORTE==========================//

    @FXML
    void onAgregarReporte() {
        hospitalController.agregarReporteAHistorial(buildReporte(), txtIdPacienteReporte.getText());
        initDataBinding();
    }

    @FXML
    void onEliminarReporte() {
        hospitalController.eliminarReporteDelHistorial(dateEliminarClonarReporte.getValue(), txtIdPacienteEliminarClonar.getText());

    }

    @FXML
    void onClonarReporte() {
        hospitalController.clonarReporte(dateEliminarClonarReporte.getValue(), txtIdPacienteEliminarClonar.getText());
    }

    @FXML
    public void onFechaReporte() {//?????
    }



    //=============================EXTRA==========================//
    @FXML
    void onRecargarListaPacientes() {
        cargarPacientes();
    }

    @FXML
    void onCargarPacientesPalindromos() {
        cargarPacientesPalindromos();
    }

    @FXML
    void onCargarPacientesVocalesRepetidas() {
        cargarPacientesVocalesRepetidas();
    }

    //========================CONFIGURACION=======================//

    @FXML
    void onGuardarConfiguracion() {
        hospitalController.guardarConfiguracionHospital(txtHorarioAtencion.getText(), txtMaxPacientes.getText(), txtReglasFacturacion.getText());
        initDataBinding();
        mostrarConfiguracion();
    }
    void mostrarConfiguracion(){
        txtInfoHospital.setText(hospitalController.configuracionActual());
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
        hospitalController = new HospitalController(HospitalApp.hospital);
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
        mostrarConfiguracion();
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

}

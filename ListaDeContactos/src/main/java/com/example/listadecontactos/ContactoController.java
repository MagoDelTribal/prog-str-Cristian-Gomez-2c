package com.example.listadecontactos;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ContactoController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cbParentesco;
    @FXML private ListView<Contacto> listViewContactos;
    @FXML private Label lblMensaje;

    private final GestorContactos gestor = new GestorContactos();

    @FXML
    public void initialize() {

        cbParentesco.setItems(FXCollections.observableArrayList(gestor.getOpcionesParentesco()));
    }

    @FXML
    public void onAgregar() {
        try {

            gestor.agregar(txtNombre.getText(), txtTelefono.getText(), cbParentesco.getValue());
            actualizarPantalla();
            onLimpiar();
            mostrarExito("Contacto agregado.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    public void onBuscar() {
        Contacto encontrado = gestor.buscar(txtNombre.getText());
        if (encontrado != null) {
            txtTelefono.setText(encontrado.getTelefono());
            cbParentesco.setValue(encontrado.getParentesco());
            mostrarExito("Contacto encontrado.");
        } else {
            mostrarError("No se encontró el contacto.");
        }
    }

    @FXML
    public void onActualizar() {
        try {
            gestor.actualizar(txtNombre.getText(), txtTelefono.getText(), cbParentesco.getValue());
            actualizarPantalla();
            mostrarExito("Contacto actualizado.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    public void onEliminar() {
        try {
            gestor.eliminar(txtNombre.getText());
            actualizarPantalla();
            onLimpiar();
            mostrarExito("Contacto eliminado.");
        } catch (IllegalArgumentException e) {
            mostrarError(e.getMessage());
        }
    }

    @FXML
    public void onLimpiar() {
        txtNombre.clear();
        txtTelefono.clear();
        cbParentesco.setValue(null);
        lblMensaje.setText("");
    }


    private void actualizarPantalla() {
        listViewContactos.setItems(FXCollections.observableArrayList(gestor.getContactos()));
    }

    private void mostrarExito(String msj) {
        lblMensaje.setText(msj);
        lblMensaje.setStyle("-fx-text-fill: green;");
    }

    private void mostrarError(String msj) {
        lblMensaje.setText(msj);
        lblMensaje.setStyle("-fx-text-fill: red;");
    }
}
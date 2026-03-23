package com.example.demo.controllers;

import com.example.demo.services.PersonaService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.List;

public class AppController {
    @FXML
    private Label labelS;
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtedad;

    @FXML
    private TextField txtcode;

    private ObservableList<String> data = FXCollections.observableArrayList();
    PersonaService service = new PersonaService();

    @FXML
    public void initialize(){
        listView.setItems(data);
        listView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    // CORRECCIÓN 1: Validar que newValue no sea null antes de separarlo
                    if (newValue != null && !newValue.trim().isEmpty()) {
                        String[] parts = newValue.split("-");
                        // Asegurarnos de que el array tenga la longitud esperada para evitar otro IndexOutOfBounds
                        if (parts.length >= 4) {
                            txtname.setText(parts[0]);
                            txtemail.setText(parts[1]);
                            txtedad.setText(parts[2]);
                            txtcode.setText(parts[3]);
                        }
                    }
                }
        );
        loadFromFile();
    }

    @FXML
    public void onReload(){
        loadFromFile();
    }

    @FXML
    public void onAddPerson(){
        try {
            String name = txtname.getText();
            String email = txtemail.getText();
            String edad = txtedad.getText();
            String code = txtcode.getText();
            service.addPerson(name, email, edad, code);
            labelS.setText("Usuario Creado Correctamente");
            labelS.setStyle("-fx-text-fill: green");
            txtname.clear();
            txtemail.clear();
            txtedad.clear();
            txtcode.clear();
            loadFromFile();
        } catch (IOException e) {
            labelS.setText("Error " + e.getMessage());
            labelS.setStyle("-fx-text-fill:red");
        } catch (IllegalArgumentException e) {
            labelS.setText("Error de datos " + e.getMessage());
            labelS.setStyle("-fx-text-fill: red");
        }
    }

    @FXML
    public void onUpdate(){
        try {
            int index = listView.getSelectionModel().getSelectedIndex();

            // CORRECCIÓN 2: Validar que haya algo seleccionado
            if (index >= 0) {
                String name = txtname.getText();
                String email = txtemail.getText();
                String edad = txtedad.getText();
                String code = txtcode.getText();

                service.uppdatePerson(index, name, email, edad, code);

                txtname.clear();
                txtemail.clear();
                txtedad.clear();
                txtcode.clear();
                labelS.setText("Se actualizaron los datos");
                labelS.setStyle("-fx-text-fill: green");

                loadFromFile(); // Recargamos la lista después de actualizar
            } else {
                labelS.setText("Selecciona una persona para actualizar");
                labelS.setStyle("-fx-text-fill: red");
            }
        } catch(Exception e) {
            labelS.setText("Hubo un error al actualizar");
            labelS.setStyle("-fx-text-fill: red");
            e.printStackTrace(); // Esto te ayudará a ver el error en consola si falla
        }
    }

    @FXML
    public void onDelete() {
        int indiceSeleccionado = listView.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado >= 0) {
            try {
                // CORRECCIÓN 3: Usar la instancia 'service' en minúscula
                service.deletePerson(indiceSeleccionado);

                txtname.clear();
                txtemail.clear();
                txtedad.clear();
                txtcode.clear();
                labelS.setText("Persona eliminada");
                labelS.setStyle("-fx-text-fill: green");

                loadFromFile(); // Recargamos la lista después de borrar
            } catch (Exception e) {
                labelS.setText("Error al eliminar");
                labelS.setStyle("-fx-text-fill: red");
                e.printStackTrace();
            }
        } else {
            labelS.setText("Selecciona una persona para eliminar");
            labelS.setStyle("-fx-text-fill: red");
        }
    }

    private void loadFromFile(){
        try {
            List<String> items = service.loadForListView();
            data.setAll(items);
            labelS.setText("Datos cargados correctamente");
            labelS.setStyle("-fx-text-fill:green");
        } catch (IOException e) {
            labelS.setText("Error: " + e.getMessage());
            labelS.setStyle("-fx-text-fill:red");
        }
    }
}
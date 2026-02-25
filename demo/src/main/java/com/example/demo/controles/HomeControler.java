package com.example.demo.controles;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeControler {

    public void onGoToForm(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/demo/form-view.fxml"));
            Scene formScene = new Scene(loader.load(), 350, 590);

            Stage stage = (Stage) ( (javafx.scene.Node) event.getSource() ).getScene().getWindow();
            stage.setScene(formScene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
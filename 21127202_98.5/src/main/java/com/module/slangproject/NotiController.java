package com.module.slangproject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NotiController {
    @FXML
    Button close_btn = new Button();
    @FXML public void close(){
        close_btn.setOnAction(actionEvent -> {
            Stage stage = (Stage) close_btn.getScene().getWindow();
            // Close the stage
            stage.close();
        });
    }
}

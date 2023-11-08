package com.module.slangproject;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Delete extends Application {
    @FXML
    private Button button_delete;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Delete.class.getResource("Delete.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("HCMUS - 21127202 - Slang Dictionary");
        stage.setScene(scene);
        stage.show();
    }
}

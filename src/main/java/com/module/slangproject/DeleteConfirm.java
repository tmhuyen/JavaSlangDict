package com.module.slangproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DeleteConfirm extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Delete.class.getResource("Delete-confirm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("HCMUS - 21127202 - Slang Dictionary");
        stage.setScene(scene);
        stage.show();
    }
}

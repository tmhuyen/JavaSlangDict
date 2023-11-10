package com.module.slangproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Update {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    Button confirm_btn = new Button();
    @FXML
    Button close_btn = new Button();
    @FXML public void close(){
        close_btn.setOnAction(actionEvent -> {
            Stage stage = (Stage) close_btn.getScene().getWindow();
            // Close the stage
            stage.close();
        });
    }
    @FXML
    public void update(){
        SlangWord slangWord = SlangWord.getInstance();
        slangWord.loadSlangWordsFromFile("src/main/data/slang_raw.txt");
        System.out.println("Updated!");
    }
}

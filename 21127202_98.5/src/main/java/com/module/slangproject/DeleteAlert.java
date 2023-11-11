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


public class DeleteAlert {
    private Stage stage;
    private Scene scene;
    private Parent parent;
    @FXML Button close_btn = new Button();
    @FXML Button confirm_btn = new Button();

    @FXML public void close(){
        close_btn.setOnAction(actionEvent -> {
            Stage stage = (Stage) close_btn.getScene().getWindow();
            // Close the stage
            stage.close();
        });
    }

    @FXML public void confirm(){
        confirm_btn.setOnAction(actionEvent -> {
            SlangWord slangWord = SlangWord.getInstance();
            DataHolder dataHolder = DataHolder.getInstance();
            System.out.println(dataHolder.getSlangWord());
            slangWord.deleteSlangWord(dataHolder.getSlangWord());
            slangWord.writeSlangtoFile();
        });
    }
}

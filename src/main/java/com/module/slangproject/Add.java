package com.module.slangproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Add {
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
    @FXML Button add_addbtn = new Button();
    @FXML TextArea add_txtnewslang = new TextArea();
    @FXML TextArea add_txtdef = new TextArea();
    public static Set<String> splitString(String input) {
        Set<String> resultSet = new HashSet<>(Arrays.asList(input.split("\n")));
        return resultSet;
    }
    @FXML public void readata(){
        AtomicReference<String> s = null;
        add_addbtn.setOnAction(actionEvent -> {
            String newslang = add_txtnewslang.getText();
            String newdef = add_txtdef.getText();
            SlangWord slangWord = SlangWord.getInstance();

        });
    }

}

package com.module.slangproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class History {
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
    Button view_btn = new Button();
    @FXML
    TextFlow history_textflow = new TextFlow();
    @FXML
    public void view(){
        history_textflow.getChildren().clear();
        DataHistory dataHistory = DataHistory.getInstance();
        ArrayList<String> his = dataHistory.getHistory();
        for (String str : his){
            Text text = new Text(str + "\n");
            history_textflow.getChildren().add(text);
        }
    }
}

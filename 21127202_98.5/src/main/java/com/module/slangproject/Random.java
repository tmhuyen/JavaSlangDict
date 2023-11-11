package com.module.slangproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;

public class Random {
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
    Button refresh_btn = new Button();
    @FXML
    TextFlow random_textflow = new TextFlow();
    @FXML
    public void refresh(){
        random_textflow.getChildren().clear();
        SlangWord slangWord = SlangWord.getInstance();
        String sw = slangWord.getRandomSlang();
        Text header = new Text(sw+ "\n");
        header.setFont(Font.font(40));
        header.setFill(Color.RED);
        Set<String> def_set = slangWord.getDefinitions(sw);
        random_textflow.getChildren().add(header);
        String footer = "";
        for (String element:def_set) {
            footer = footer + element + ", ";
        }
        Text text = new Text(footer+"\n\n\n");
        text.setFont(Font.font(30));
        text.setFill(Color.BLUE);
        random_textflow.getChildren().add(text);
        System.out.println("Refresh!");
    }
}

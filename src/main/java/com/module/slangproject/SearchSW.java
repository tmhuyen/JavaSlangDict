package com.module.slangproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;

public class SearchSW {
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

    SlangWord slangWord = SlangWord.getInstance();
    @FXML Button search_btn = new Button();
    @FXML TextField sw_textfield = new TextField();
    @FXML TextFlow def_textflow = new TextFlow();

    @FXML public void searchSW(){
        search_btn.setOnAction(actionEvent -> {
            System.out.println("clicked");
            String sw = sw_textfield.getText().trim();
            if (slangWord.isWordExist(sw) == false){
                def_textflow.getChildren().clear();
                Text text = new Text("Can not find this slang word!");
                def_textflow.getChildren().add(text);
            }
            else {
                def_textflow.getChildren().clear();
                String def = "";
                Set<String> def_set = slangWord.getDefinitions(sw);
                for (String element:def_set) {
                    Text text = new Text(element + "\n");
                    // Add the Text node to the TextFlow
                    def_textflow.getChildren().add(text);
                }
            }
        });
    }
}

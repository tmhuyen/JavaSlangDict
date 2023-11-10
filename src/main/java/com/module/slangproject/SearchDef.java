package com.module.slangproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Set;

public class SearchDef {
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
    Button search_btn = new Button();
    @FXML
    TextField def_textfield = new TextField();
    @FXML
    TextFlow sw_textflow = new TextFlow();
    @FXML
    public void searchDef() {
        search_btn.setOnAction(actionEvent -> {
            String def = def_textfield.getText().trim();
            SlangWord slangWord = SlangWord.getInstance();
            Set<String> sw_set = slangWord.getSlangWordsWithDefinition(def);
            if (sw_set.isEmpty()){
                sw_textflow.getChildren().clear();
                Text text = new Text("Can not find any slang word has this word in its definition!");
                sw_textflow.getChildren().add(text);
            }
            else {
                sw_textflow.getChildren().clear();
                // Iterate over the set
                for (String str : sw_set) {
                    // Create a new Text node for each string
                    Text text = new Text(str + ", ");

                    // Add the Text node to the TextFlow
                    sw_textflow.getChildren().add(text);
                }
            }

        });
    }
}

package com.module.slangproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Edit {
    private Stage stage;
    private Scene scene;
    private Parent parent;

    public static Set<String> splitString(String input) {
        Set<String> resultSet = new HashSet<>(Arrays.asList(input.split("\n")));
        return resultSet;
    }

    @FXML
    Button search_btn = new Button();
    @FXML
    Button edit_btn = new Button();
    @FXML
    TextField sw_textfield = new TextField();
    @FXML
    TextArea def_textarea = new TextArea();

    public void switchToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    SlangWord slangWord = SlangWord.getInstance();
    @FXML public void search(){
        search_btn.setOnAction(actionEvent -> {
            System.out.println("clicked");
            String sw = sw_textfield.getText().trim();
            if (slangWord.isWordExist(sw) == false){
                def_textarea.setText("Can not find the definition of this slang word!");
            }
            else {
                String text = "";
                Set<String> def_set = slangWord.getDefinitions(sw);
                for (String element:def_set) {
                    text = text + element + "\n";
                }
                def_textarea.setText(text);
            }
        });
    }
    @FXML public void edit(){
        edit_btn.setOnAction(actionEvent -> {
            String sw = sw_textfield.getText();
            String newdef = def_textarea.getText();
            Set<String> newdef_set = splitString(newdef);
            slangWord.overwriteValue(sw,newdef_set);
            System.out.println("Edit finished!");
            slangWord.writeSlangtoFile();
        });
    }
}

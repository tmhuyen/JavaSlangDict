package com.module.slangproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class DefQuiz{
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
    Button submit_btn = new Button();
    @FXML
    Button get_btn = new Button();
    @FXML
    RadioButton radio01,radio02,radio03,radio04;
    @FXML
    TextFlow question_textflow = new TextFlow();
    SlangWord slangWord = SlangWord.getInstance();
    String answer = slangWord.getRandomSlang();
    String question = slangWord.getDefinitionsAsString(answer);
    @FXML public void check()
    {
        if ((radio01.isSelected() && radio01.getText() == answer) ||
                (radio02.isSelected() && radio02.getText() == answer) ||
                (radio03.isSelected() && radio03.getText() == answer) ||
                (radio04.isSelected() && radio04.getText() == answer))
        {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Correct.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Incorrect.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @FXML public void getnew()
    {
        answer = slangWord.getRandomSlang();
        question = slangWord.getDefinitionsAsString(answer);
        question_textflow.getChildren().clear();
        Text ques = new Text(question);
        ques.setFill(Color.RED);
        ques.setFont(Font.font(30));
        question_textflow.getChildren().add(ques);
        int ran =  new Random().nextInt(4);
        for (int i = 0; i < 4; i++){
            if (i == ran){
                if (i == 0){
                    radio01.setText(answer);
                }
                if (i == 1){
                    radio02.setText(answer);
                }
                if (i == 2){
                    radio03.setText(answer);
                }
                if (i == 3){
                    radio04.setText(answer);
                }
            }
            else  {
                if (i == 0){
                    radio01.setText(slangWord.getRandomSlang());
                }
                else if (i == 1){
                    radio02.setText(slangWord.getRandomSlang());
                }
                else if (i == 2){
                    radio03.setText(slangWord.getRandomSlang());
                }
                else if (i == 3){
                    radio04.setText(slangWord.getRandomSlang());
                }
            }
        }
    }
}

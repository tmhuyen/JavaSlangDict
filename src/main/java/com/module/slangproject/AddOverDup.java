package com.module.slangproject;

import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddOverDup {
    @FXML Button close_btn = new Button();
    @FXML Button overwrite_btn = new Button();
    @FXML Button duplicate_btn = new Button();

    @FXML public void close(){
        close_btn.setOnAction(actionEvent -> {
            Stage stage = (Stage) close_btn.getScene().getWindow();
            // Close the stage
            stage.close();
        });
    }
    @FXML public void overwrite(){
        overwrite_btn.setOnAction(actionEvent -> {
            SlangWord slangWord = SlangWord.getInstance();
            DataHolder dataHolder = DataHolder.getInstance();
            System.out.println(dataHolder.getSlangWord());
            System.out.println(dataHolder.getDefinitions());
            slangWord.overwriteValue(dataHolder.getSlangWord(), dataHolder.getDefinitions());
            slangWord.writeSlangtoFile();
        });
    }

    @FXML public void duplicate(){
        duplicate_btn.setOnAction(actionEvent -> {
            SlangWord slangWord = SlangWord.getInstance();
            DataHolder dataHolder = DataHolder.getInstance();
            slangWord.addSlangWord(dataHolder.getSlangWord(), dataHolder.getDefinitions());
            slangWord.writeSlangtoFile();
        });
    }
}

package com.module.slangproject;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Home{

    private Stage stage;
    private Scene scene;
    private Parent parent;
    public void switchToAdd(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Add.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDelete(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToEdit(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Edit.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSearchDef(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchDef.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSearchSW(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SearchSW.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDefQuiz(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DefQuiz.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSWQuiz(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SWQuiz.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToRandom(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Random.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void overlayUpdate(ActionEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Update.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void switchToHistory(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("History.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}

package com.example.termpaper;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;

public class ActionController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void select(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SelectInsuranceScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void update(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("UpdateInsuranceScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void delete(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("DeleteInsuranceScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void view (ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("ViewInsuranceScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
       // stage.setResizable(true);
        stage.setMaximized(true);
        stage.show();
    }
    public void logout(ActionEvent event) throws IOException{

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Are you sure?");
        //alert.setContentText("");
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        if (alert.showAndWait().get() == ButtonType.OK){
            Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}

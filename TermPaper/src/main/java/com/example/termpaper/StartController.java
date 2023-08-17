package com.example.termpaper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class StartController {
    private Stage stage;
    private Scene scene;
    @FXML
    Button button;

    public void switchToSceneRegister(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("RegisterScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToSceneLogIn(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("LogInScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
/*    public void switchToSceneExit(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("ExitScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }*/
    public void logout(ActionEvent event) throws IOException{

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("Are you sure?");
        //alert.setContentText("");
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();

        if (alert.showAndWait().get() == ButtonType.OK){
            System.out.println("You successfully logged out");
            stage.close();
        }
    }


}
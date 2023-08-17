package com.example.termpaper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SelectController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int choice=0;
    @FXML
    private RadioButton casco, motorLiability, greenCard;

    public void select(ActionEvent event) throws IOException{

        if(casco.isSelected()) {
            //System.out.println("CASCO");
            choice = 1;
        }
        else if(motorLiability.isSelected()) {
            //System.out.println("Motor Liability");
            choice = 2;
        }
        else if(greenCard.isSelected()) {
            //System.out.println("Green Card");
            choice = 3;
        }

    }
    public void apply(ActionEvent event) throws IOException{
        switch (choice){
            case 1:
                casco(event);
                break;
            case 2:
                motorLiability(event);
                break;
            case 3:
                greenCard(event);
                break;
            case 0:
                error(event);
                break;

        }
    }

    public void backToActionScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActionScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void casco(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CascoScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void motorLiability(ActionEvent event) throws IOException {
        Parent  root = FXMLLoader.load(getClass().getResource("MotorLiabilityScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void greenCard(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("GreenCardScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void error(ActionEvent event) throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SelectErrorScene.fxml"));
        stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("D:\\InteliJ IDEA Java\\Term Paper\\src\\main\\resources\\com\\example\\termpaper\\error.png");
        stage.getIcons().add(icon);
        stage.setTitle("Error");
        stage.setScene(scene);
        stage.show();
    }

    public void close(ActionEvent event)
    {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }


}

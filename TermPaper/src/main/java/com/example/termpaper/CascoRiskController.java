package com.example.termpaper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CascoRiskController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private CheckBox animalAttack;
    @FXML
    private CheckBox fireExplosion;
    @FXML
    private CheckBox fallingObjects;
    @FXML
    private CheckBox disaster;
    @FXML
    private CheckBox militaryRisks;
    @FXML
    private CheckBox completeDeath;
    @FXML
    private CheckBox illegalActionsOfThirdParties;
    @FXML
    private CheckBox carTheft;
    @FXML
    private CheckBox roadAccident;

    private int levelOfRisk;

    public void apply(ActionEvent event) throws IOException{
        levelOfRisk = 0;
        int[] riskArr = new int[9];
        if (animalAttack.isSelected())
        {
            levelOfRisk+=1;
            riskArr[0]=1;
        }
        else {
            riskArr[0]=0;
        }
        if (fireExplosion.isSelected())
        {
            levelOfRisk+=2;
            riskArr[1]=1;
        }
        else {
            riskArr[1]=0;
        }
        if (fallingObjects.isSelected())
        {
            levelOfRisk+=3;
            riskArr[2]=1;
        }
        else {
            riskArr[2]=0;
        }
        if (disaster.isSelected())
        {
            levelOfRisk+=4;
            riskArr[3]=1;
        }
        else {
            riskArr[3]=0;
        }
        if (militaryRisks.isSelected())
        {
            levelOfRisk+=5;
            riskArr[4]=1;
        }
        else {
            riskArr[4]=0;
        }
        if (completeDeath.isSelected())
        {
            levelOfRisk+=6;
            riskArr[5]=1;
        }
        else {
            riskArr[5]=0;
        }
        if (illegalActionsOfThirdParties.isSelected())
        {
            levelOfRisk+=7;
            riskArr[6]=1;
        }
        else {
            riskArr[6]=0;
        }
        if (carTheft.isSelected())
        {
            levelOfRisk+=8;
            riskArr[7]=1;
        }
        else {
            riskArr[7]=0;
        }
        if (roadAccident.isSelected())
        {
            levelOfRisk+=9;
            riskArr[8]=1;
        }
        else {
            riskArr[8]=0;
        }

        if (levelOfRisk == 0)
        {
            error(event);
        }
        else {
            DatabaseConnect databaseConnect = new DatabaseConnect();
            int id_insurance = databaseConnect.risks(riskArr,levelOfRisk);
            Parent root = FXMLLoader.load(getClass().getResource("CascoInsertScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public void backToActionScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActionScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void error(ActionEvent event) throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CascoErrorRiskScene.fxml"));
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

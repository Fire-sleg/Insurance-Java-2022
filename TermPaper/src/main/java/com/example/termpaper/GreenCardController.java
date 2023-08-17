package com.example.termpaper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class GreenCardController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ComboBox<String> regionOfStay = new ComboBox<>();
    @FXML
    private TextField vehicle;
    @FXML
    private TextField company;
    @FXML
    private Label cost;

    private String vehicleG;
    private String companyG;
    private double costG;
    private String region;
    private int levelOfRisk = 9;

    public void calculate(ActionEvent event) throws IOException { //!!!!!!!!!!!!!!!!!
        DatabaseConnect databaseConnect = new DatabaseConnect();

        vehicleG = vehicle.getText();
        companyG = company.getText();

        if (Objects.equals(region,"") &&
            Objects.equals(vehicleG, "") &&
            Objects.equals(companyG,""))
        {
            errorCalculate();
            return;
        }
        double k = switch (region) {
            case "England" -> 1.1;
            case "France" -> 1.2;
            case "Germany" -> 1.3;
            case "Italy" -> 1.4;
            case "Spain" -> 1.5;
            default -> 0;
        };

        costG = Math.round ((1 + (double)levelOfRisk/10) * k * 1000);
        cost.setText("cost: "+costG);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] regions = {"England","France","Germany","Italy","Spain"};
        regionOfStay.getItems().addAll(regions);
        regionOfStay.setOnAction(event -> {
            region = regionOfStay.getValue();
        });

    }



    public void apply(ActionEvent event) throws IOException {
        if (Objects.equals(cost.getText(), "cost:"))
        {
            errorApply();
        }
        else{
            int[] tempArr = {0,0,0,0,0,0,0,0,1};
            DatabaseConnect databaseConnect = new DatabaseConnect();
            databaseConnect.risks( tempArr,9);
            databaseConnect.commonData(companyG,costG);

            databaseConnect.greenCard(region,vehicleG);
            databaseConnect.insuranceGreenCard();
            close(event);
            operationMessage();
        }
    }

    public void errorCalculate() throws IOException{
        //errorLabel.setText("ERROR");
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CalculateErrorGreenCardScene.fxml"));
        stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("D:\\InteliJ IDEA Java\\Term Paper\\src\\main\\resources\\com\\example\\termpaper\\error.png");
        stage.getIcons().add(icon);
        stage.setTitle("Error");
        stage.setScene(scene);
        stage.show();
    }

    public void errorApply() throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ApplyErrorGreenCardScene.fxml"));
        stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("D:\\InteliJ IDEA Java\\Term Paper\\src\\main\\resources\\com\\example\\termpaper\\error.png");
        stage.getIcons().add(icon);
        stage.setTitle("Error");
        stage.setScene(scene);
        stage.show();
    }

    public void operationMessage() throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("OperationMessageGreenCardScene.fxml"));
        stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("D:\\InteliJ IDEA Java\\Term Paper\\src\\main\\resources\\com\\example\\termpaper\\Green_mark.png");
        stage.getIcons().add(icon);
        stage.setTitle("Purchased successfully");
        stage.setScene(scene);
        stage.show();
    }

    public void close(ActionEvent event)
    {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void backToActionScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActionScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void closeActionScene(ActionEvent event) throws IOException{
        close(event);

        Parent root = FXMLLoader.load(getClass().getResource("ActionScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setResizable(false);
        Image icon = new Image("D:\\InteliJ IDEA Java\\Term Paper\\src\\main\\resources\\com\\example\\termpaper\\images.png");
        stage.getIcons().add(icon);
        stage.setTitle("Insurance");
        stage.setScene(scene);
        stage.show();
    }
}

package com.example.termpaper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MotorLiabilityController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField company;
    @FXML
    private TextField carBrand;
    @FXML
    private TextField carModel;
    @FXML
    private TextField yearOfManufacture;
    @FXML
    private TextField carPrice;
    @FXML
    private TextField carNumber;
    @FXML
    private TextField bodyNumber;
    @FXML
    private Label cost;

    private String companyM;
    private String carBrandM;
    private String carModelM;
    private int yearOfManufactureM;
    private int carPriceM;
    private String carNumberM;
    private String bodyNumberM;
    private double costM;
    private int levelOfRisk = 9;

    public void calculate(ActionEvent event) throws IOException {
        DatabaseConnect databaseConnect = new DatabaseConnect();

        companyM = company.getText();
        carBrandM = carBrand.getText();
        carModelM = carModel.getText();
        carNumberM = carNumber.getText();
        bodyNumberM = bodyNumber.getText();

        yearOfManufactureM = 0;
        try{
            yearOfManufactureM = Integer.parseInt(yearOfManufacture.getText());
        }
        catch (RuntimeException e)
        {
            errorCalculate();
            return;
        }

        carPriceM = 0;
        try{
            carPriceM = Integer.parseInt(carPrice.getText());
        }
        catch (RuntimeException e)
        {
            errorCalculate();
            return;
        }

        if (Objects.equals(companyM, "") &&
            Objects.equals(carBrandM, "") &&
            Objects.equals(carModelM, "") &&
            Objects.equals(carNumberM,"") &&
            Objects.equals(bodyNumberM,""))
        {
            errorCalculate();
            return;
        }

        costM = (1 + (double)levelOfRisk/10) * carPriceM;
        cost.setText("cost: "+costM);
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
            databaseConnect.commonData(companyM,costM);
            databaseConnect.motorLiability(carNumberM,carBrandM,carModelM,yearOfManufactureM,carPriceM,bodyNumberM);
            databaseConnect.insuranceMotorLiability();
            close(event);
            operationMessage();
        }
    }

    public void errorCalculate() throws IOException{
        //errorLabel.setText("ERROR");
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CalculateErrorMotorLiabilityScene.fxml"));
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ApplyErrorMotorLiabilityScene.fxml"));
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("OperationMessageMotorLiabilityScene.fxml"));
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

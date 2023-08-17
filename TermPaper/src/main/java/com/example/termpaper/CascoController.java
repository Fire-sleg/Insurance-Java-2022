package com.example.termpaper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class CascoController {
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
    private Label cost;
    private String companyC;
    private String carBrandC;
    private String carModelC;
    private int yearOfManufactureC;
    private int carPriceC;
    private int levelOfRisk;
    private double costC;
    public void calculate(ActionEvent event) throws IOException { //!!!!!!!!!!!!!!!!!
        DatabaseConnect databaseConnect = new DatabaseConnect();

        companyC = company.getText();
        carBrandC = carBrand.getText();
        carModelC = carModel.getText();

        yearOfManufactureC = 0;
        try{
            yearOfManufactureC = Integer.parseInt(yearOfManufacture.getText());
        }
        catch (RuntimeException e)
        {
            errorCalculate();
            return;
        }

        carPriceC = 0;
        try{
            carPriceC = Integer.parseInt(carPrice.getText());
        }
        catch (RuntimeException e)
        {
            errorCalculate();
            return;
        }

        if (Objects.equals(companyC, "") &&
            Objects.equals(carBrandC, "") &&
            Objects.equals(carModelC, ""))
        {
            errorCalculate();
            return;
        }
        levelOfRisk = databaseConnect.levelOfRisk();
        costC = (1 + (double)levelOfRisk/10) * carPriceC;
        cost.setText("cost: "+costC);


    }

    public void apply(ActionEvent event) throws IOException {
        if (Objects.equals(cost.getText(), "cost:"))
        {
            errorApply();
        }
        else{
            DatabaseConnect databaseConnect = new DatabaseConnect();
            databaseConnect.commonData(companyC,costC);
            databaseConnect.casco(carBrandC,carModelC,yearOfManufactureC,carPriceC);
            databaseConnect.insuranceCasco();
            close(event);
            operationMessage();
        }
    }
    public void backToCascoScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CascoScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void errorCalculate() throws IOException{
        //errorLabel.setText("ERROR");
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("CalculateErrorCascoScene.fxml"));
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
    public void errorApply() throws IOException {
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("ApplyErrorCascoScene.fxml"));
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("OperationMessageCascoScene.fxml"));
        stage.setResizable(false);
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("D:\\InteliJ IDEA Java\\Term Paper\\src\\main\\resources\\com\\example\\termpaper\\Green_mark.png");
        stage.getIcons().add(icon);
        stage.setTitle("Purchased successfully");
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

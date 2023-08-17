package com.example.termpaper;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ViewController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<CommonData> commonDataTable;
    @FXML
    private TableColumn<CommonData, LocalDate> start_date = new TableColumn<>();
    @FXML
    private TableColumn<CommonData, Integer> validity = new TableColumn<>();
    @FXML
    private TableColumn<CommonData, LocalDate> finish_date = new TableColumn<>();
    @FXML
    private TableColumn<CommonData, String> company = new TableColumn<>();
    @FXML
    private TableColumn<CommonData, Double> cost = new TableColumn<>();
    @FXML
    private TableView<Casco> cascoTable;
    @FXML
    private TableColumn<Casco, String> car_brandC = new TableColumn<>();
    @FXML
    private TableColumn<Casco, String> car_modelC = new TableColumn<>();
    @FXML
    private TableColumn<Casco, Integer> yearC = new TableColumn<>();
    @FXML
    private TableColumn<Casco, Integer> car_priceC = new TableColumn<>();
    @FXML
    private TableView<MotorLiability> motorLiabilityTable;
    @FXML
    private TableColumn<MotorLiability, String> car_numberM = new TableColumn<>();
    @FXML
    private TableColumn<MotorLiability, String> car_brandM = new TableColumn<>();
    @FXML
    private TableColumn<MotorLiability, String> car_modelM = new TableColumn<>();
    @FXML
    private TableColumn<MotorLiability, Integer> yearM = new TableColumn<>();
    @FXML
    private TableColumn<MotorLiability, String> body_numberM = new TableColumn<>();
    @FXML
    private TableView<GreenCard> greenCardTable;
    @FXML
    private TableColumn<GreenCard, String> region_of_stayG = new TableColumn<>();
    @FXML
    private TableColumn<GreenCard, String> vehicleG = new TableColumn<>();



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        start_date.setCellValueFactory(new PropertyValueFactory<CommonData,LocalDate>("start_date"));
        validity.setCellValueFactory(new PropertyValueFactory<CommonData,Integer>("validity"));
        finish_date.setCellValueFactory(new PropertyValueFactory<CommonData,LocalDate>("finish_date"));
        company.setCellValueFactory(new PropertyValueFactory<CommonData,String>("company"));
        cost.setCellValueFactory(new PropertyValueFactory<CommonData,Double>("cost"));

        car_brandC.setCellValueFactory(new PropertyValueFactory<Casco,String>("car_brand"));
        car_modelC.setCellValueFactory(new PropertyValueFactory<Casco,String>("car_model"));
        yearC.setCellValueFactory(new PropertyValueFactory<Casco,Integer>("year_of_manufacture_of_the_car"));
        car_priceC.setCellValueFactory(new PropertyValueFactory<Casco,Integer>("car_price"));

        car_numberM.setCellValueFactory(new PropertyValueFactory<MotorLiability,String>("car_number"));
        car_brandM.setCellValueFactory(new PropertyValueFactory<MotorLiability,String>("car_brand"));
        car_modelM.setCellValueFactory(new PropertyValueFactory<MotorLiability,String>("car_model"));
        yearM.setCellValueFactory(new PropertyValueFactory<MotorLiability,Integer>("year_of_manufacture_of_the_car"));
        body_numberM.setCellValueFactory(new PropertyValueFactory<MotorLiability,String>("body_number"));

        region_of_stayG.setCellValueFactory(new PropertyValueFactory<GreenCard,String>("region_of_stay"));
        vehicleG.setCellValueFactory(new PropertyValueFactory<GreenCard,String>("vehicle"));
    }

    public void getCommonDataView(ActionEvent event) throws IOException {
        DatabaseConnect databaseConnect = new DatabaseConnect();
        ObservableList<CommonData> list = databaseConnect.getCommonData();
        commonDataTable.setItems(list);
    }

    public void view(ActionEvent event) throws IOException {
        DatabaseConnect databaseConnect = new DatabaseConnect();
        int id = commonDataTable.getSelectionModel().getSelectedIndex() + 1;
        int[] arr = databaseConnect.view(id);
        switch (arr[1]) {
            case 1 -> {
                ObservableList<Casco> list = databaseConnect.getDataCasco(arr[0]);
                cascoTable.setItems(list);
                for(int i = 0;i < list.size();i++)
                {
                    System.out.println(list.get(i).toString());
                }
            }
            case 2 -> {
                ObservableList<MotorLiability> list1 = databaseConnect.getDataMotorLiability(arr[0]);
                motorLiabilityTable.setItems(list1);
                for(int i = 0;i < list1.size();i++)
                {
                    System.out.println(list1.get(i).toString());
                }
            }
            case 3 -> {
                ObservableList<GreenCard> list2 = databaseConnect.getDataGreenData(arr[0]);
                greenCardTable.setItems(list2);
                for(int i = 0;i < list2.size();i++)
                {
                    System.out.println(list2.get(i).toString());
                }
            }
        }
    }

    public void backToActionScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActionScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root,600,400);
        stage.setScene(scene);
        stage.setMaximized(false);
        stage.show();
    }
}

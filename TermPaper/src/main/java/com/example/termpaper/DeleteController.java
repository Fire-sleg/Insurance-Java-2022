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

public class DeleteController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<CommonData> insuranceTable = new TableView<>();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        start_date.setCellValueFactory(new PropertyValueFactory<CommonData,LocalDate>("start_date"));
        validity.setCellValueFactory(new PropertyValueFactory<CommonData,Integer>("validity"));
        finish_date.setCellValueFactory(new PropertyValueFactory<CommonData,LocalDate>("finish_date"));
        company.setCellValueFactory(new PropertyValueFactory<CommonData,String>("company"));
        cost.setCellValueFactory(new PropertyValueFactory<CommonData,Double>("cost"));
    }

    public void getData(ActionEvent event) throws IOException {
        DatabaseConnect databaseConnect = new DatabaseConnect();
        ObservableList<CommonData> list = databaseConnect.getCommonData();
        insuranceTable.setItems(list);
    }

    public void delete(ActionEvent event) throws IOException {
        int id = insuranceTable.getSelectionModel().getSelectedIndex() + 1;

        DatabaseConnect databaseConnect = new DatabaseConnect();
        databaseConnect.delete(id);
    }

    public void backToActionScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ActionScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}

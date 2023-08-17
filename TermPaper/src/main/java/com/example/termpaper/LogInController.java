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

public class LogInController {
    private Stage stage;
    private Scene scene;
    @FXML
    TextField emailLogIn;
    @FXML
    TextField passwordLogIn;
    @FXML
    Label errorLabel;
    public void applyLogIn(ActionEvent event) throws IOException {
        //check
        String email = emailLogIn.getText();
        String password = passwordLogIn.getText();
        DatabaseConnect databaseConnect = new DatabaseConnect();
        int id = databaseConnect.logIn(email,password);
        System.out.println(id);
        if (id > 0)
        {
            Parent root = FXMLLoader.load(getClass().getResource("ActionScene.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            incorrectLogIn();
        }
    }
    public void incorrectLogIn() throws IOException{
        //errorLabel.setText("ERROR");
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LogInErrorScene.fxml"));
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

    public void backToStartScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("StartScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

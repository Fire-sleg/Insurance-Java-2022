package com.example.termpaper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    private Stage stage;
    private Scene scene;
    @FXML
    TextField name;
    @FXML
    TextField surname;
    @FXML
    TextField middleName;
    @FXML
    TextField city;
    @FXML
    TextField street;
    @FXML
    TextField house;
    @FXML
    TextField apartment;
    @FXML
    TextField TIN;
    @FXML
    TextField email;
    @FXML
    TextField phoneNumber;
    @FXML
    TextField password1;
    @FXML
    TextField password2;
    public void applyRegister(ActionEvent event) throws IOException {
        String nameR = name.getText();
        String surnameR = surname.getText();
        String middleNameR = middleName.getText();
        String cityR = city.getText();
        String streetR = street.getText();
        int houseR = 0;
        try{
            houseR = Integer.parseInt(house.getText());
        }
        catch (RuntimeException e)
        {
            errorRegister();
            return;
        }

        int apartmentR = 0;
        try{
            apartmentR = Integer.parseInt(apartment.getText());
        }
        catch (RuntimeException e)
        {
            errorRegister();
            return;
        }

        String TINR = TIN.getText();
        String emailR = email.getText();
        String phoneNumberR = phoneNumber.getText();
        String password1R = password1.getText();
        String password2R = password2.getText();

        if (!Objects.equals(password1R, password2R))
        {
            errorRegister();
            return;
        }
        if (Objects.equals(nameR, "") &&
            Objects.equals(surnameR, "") &&
            Objects.equals(middleNameR, "") &&
            Objects.equals(cityR, "") &&
            Objects.equals(streetR, "") &&
            Objects.equals(TINR, "") &&
            Objects.equals(emailR, "") &&
            Objects.equals(phoneNumberR, "") &&
            Objects.equals(password1R, ""))
        {
            errorRegister();
            return;
        }
        DatabaseConnect databaseConnect = new DatabaseConnect();
        int id = databaseConnect.register(nameR,surnameR,middleNameR,cityR,streetR,houseR,apartmentR,TINR,emailR,phoneNumberR,password1R);
        databaseConnect.temp(emailR,password1R);
        Parent root = FXMLLoader.load(getClass().getResource("ActionScene.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void errorRegister() throws IOException{
        //errorLabel.setText("ERROR");
        stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("RegisterErrorScene.fxml"));
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

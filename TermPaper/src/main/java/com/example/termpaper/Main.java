package com.example.termpaper;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("StartScene.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("start/StartScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        //stage.setMaximized(true);
        stage.setResizable(false);
        Image icon = new Image("D:\\InteliJ IDEA Java\\Term Paper\\src\\main\\resources\\com\\example\\termpaper\\images.png");
        stage.getIcons().add(icon);
        stage.setTitle("Insurance company");
// static login
     //   getter setter
        //scene.getStylesheets().add(0,"doc.css");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
       launch();
        /*Calendar calendar = Calendar.getInstance();
        LocalDate time = LocalDate.now();
        System.out.println(time.withYear(time.getYear()+1));
        System.out.println(time);*/


    }
}
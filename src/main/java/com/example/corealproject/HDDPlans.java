package com.example.corealproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HDDPlans extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HDDPlans.class.getResource("hdd-plans.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 420);
        stage.setTitle("HDD plans");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
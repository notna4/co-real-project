package com.example.corealproject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 420);
        stage.setTitle("Main");
        stage.setScene(scene);
        stage.setHeight(420);
        stage.setWidth(720);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
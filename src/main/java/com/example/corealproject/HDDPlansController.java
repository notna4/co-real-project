package com.example.corealproject;

import HDD.HDDBenchmarkV1;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HDDPlansController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label titleMain;

    @FXML
    protected void startHDDSequential() {
        System.out.println("start test");
        HDDBenchmarkV1 test = new HDDBenchmarkV1();
        test.start(10);

    }
    public void backToMain(ActionEvent event) throws IOException {
        System.out.println("das");
        FXMLLoader fxmlLoader = new FXMLLoader(HDDPlans.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 340);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("HDD Plans");
        stage.setScene(scene);
        stage.show();
    }
}
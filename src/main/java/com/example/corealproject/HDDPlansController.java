package com.example.corealproject;

import HDD.HDDBenchmarkV1;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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
}
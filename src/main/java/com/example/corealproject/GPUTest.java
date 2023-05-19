package com.example.corealproject;

import GPU.GPU_Benchmark;
import HDD.RandAccess.RandomReadWriteImproved;
import HDD.RandAccess.RandomReadWriteMain;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.CENTER_LEFT;
import static javafx.scene.layout.BorderPane.setAlignment;

public class GPUTest {

    public int size;

    public GPUTest(int mode) {
        System.out.println("mode: " + mode);
    }

    public BorderPane createContent(Stage primaryStage, int mode, String nameText) {

        // Create the title text
        Text title = new Text("GPU test: " + mode);
        Font font = null;
        try {
            font = Font.loadFont(new File("src/main/java/com/example/corealproject/fonts/Inter-Bold.ttf").toURI().toURL().toExternalForm(), 30);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        title.setFont(font);
        title.setFill(Color.WHITE);

        // Create the "Basic" section

        Font tagFont = null;
        try {
            tagFont = Font.loadFont(new File("src/main/java/com/example/corealproject/fonts/Inter-Medium.ttf").toURI().toURL().toExternalForm(), 15);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        Font mainTitleFont = null;
        try {
            mainTitleFont = Font.loadFont(new File("src/main/java/com/example/corealproject/fonts/Inter-Bold.ttf").toURI().toURL().toExternalForm(), 20);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        // Create the Back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            primaryStage.setScene(new Scene(new GPUMenu().createContent(primaryStage, nameText), 720, 420));

            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });

        Text results = new Text("Results will appear here.");
        results.setFont(tagFont);
        results.setFill(Color.WHITE);


        // Create the Start button
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
//            primaryStage.setScene(new Scene(new HDDPlans().createContent(primaryStage), 720, 420));
//            System.out.println("startttt");
            startButton.setDisable(true);
            backButton.setDisable(true);
            startButton.setText("Computing..");
            GPU_Benchmark gpu = new GPU_Benchmark();

            gpu.gpuBench(String.valueOf(mode));

//            results.setText(String.valueOf(scor));


            // Wait for 2 seconds and show the button again
            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(2), event -> {
                        startButton.setDisable(false);
                        backButton.setDisable(false);
                        startButton.setText("Start again");

                    })
            );
            timeline.play();
            // Set the background color of the scene
//            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });

        Font btnFont = null;
        try {
            btnFont = Font.loadFont(new File("src/main/java/com/example/corealproject/fonts/Inter-Bold.ttf").toURI().toURL().toExternalForm(), 16);
//            System.out.println(font);
        } catch (MalformedURLException e) {
//            System.out.println("aici");
            throw new RuntimeException(e);
        }


        backButton.setFont(btnFont);
        startButton.setFont(btnFont);

        backButton.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), backButton);
            st.setToX(1.1);
//            testButton.setBackground(Background.fill(Color.WHITE));
            backButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: white; -fx-background-color: '#383838'");
            st.setToY(1.1);
            st.play();
        });
        backButton.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), backButton);
            st.setToX(1.0);
            backButton.setBackground(Background.fill(Color.TRANSPARENT));
            backButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
            st.setToY(1.0);
            st.play();
        });

        backButton.setBackground(Background.fill(Color.TRANSPARENT));
        backButton.setPadding(new Insets(10));
        backButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");

        // -----

        startButton.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), startButton);
            st.setToX(1.1);
//            testButton.setBackground(Background.fill(Color.WHITE));
            startButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: white; -fx-background-color: '#383838'");
            st.setToY(1.1);
            st.play();
        });
        startButton.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), startButton);
            st.setToX(1.0);
            startButton.setBackground(Background.fill(Color.TRANSPARENT));
            startButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
            st.setToY(1.0);
            st.play();
        });

        startButton.setBackground(Background.fill(Color.TRANSPARENT));
        startButton.setPadding(new Insets(10));
        startButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");



        // Create the layout
        HBox columns = new HBox(backButton, startButton, results);
        columns.setSpacing(20);

        columns.setAlignment(CENTER);
        BorderPane root = new BorderPane(columns);
        root.setPadding(new Insets(20));
        HBox header = new HBox(backButton, title);
        header.setAlignment(CENTER_LEFT);
        header.setSpacing(20);
        root.setTop(header);
        setAlignment(title, CENTER);
        setAlignment(backButton, CENTER);

        return root;
    }
}
package com.example.corealproject;

import HDD.SeqWriteBench;
import HDD.SeqWriteMain;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.BorderPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicReference;

import static javafx.geometry.Pos.*;
import static javafx.scene.layout.BorderPane.setAlignment;

public class SequentialTest {

    public int size;

    private static final String FILE_NAME = "ScoreHistoryHDDRandom.txt";

    public SequentialTest(int size) {
        System.out.println("size: " + size);
    }

    public BorderPane createContent(Stage primaryStage, int size, String nameText) {

        // Create the title text
        Text title = new Text("Sequential Read and Write: " + size + "MB");
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
            primaryStage.setScene(new Scene(new HDDPlans().createContent(primaryStage, nameText), 720, 420));

            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });

        Text results = new Text("Results will appear here.");
        results.setFont(tagFont);
        results.setFill(Color.WHITE);

        SeqWriteBench seqBench = new SeqWriteBench();
        SeqWriteMain seq = new SeqWriteMain();
        AtomicReference<Double> score = new AtomicReference<>((double) 0);


        // Create the Start button
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
//            primaryStage.setScene(new Scene(new HDDPlans().createContent(primaryStage), 720, 420));
//            System.out.println("startttt");
            startButton.setDisable(true);
            backButton.setDisable(true);
            startButton.setText("Computing..");

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(2), event -> {
                        score.set(seq.start(size));
                    })
            );
            timeline.play();



            // Wait for 2 seconds and show the button again
            Timeline timeline1 = new Timeline(
                    new KeyFrame(Duration.seconds(2), event -> {
                        startButton.setDisable(false);
                        backButton.setDisable(false);
                        startButton.setText("Start again");

                        results.setText(String.valueOf(score));

                        try {
                            FileWriter text = new FileWriter(FILE_NAME,true);
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String formattedTime = now.format(formatter);
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                                writer.write("HDD - Seq" + "," + nameText+ "," + formattedTime + "," + score + "," + size +"\n");
                            } catch (IOException err) {
                                err.printStackTrace();
                            }
                            text.close();
                            System.out.println("Score posted!");
                        } catch (IOException err) {
                            System.out.println("Could not post score,error occured!");
                            err.printStackTrace();
                        }

                    })
            );
            timeline1.play();
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

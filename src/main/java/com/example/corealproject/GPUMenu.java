package com.example.corealproject;

import GPU.GPU_Benchmark;
import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.CENTER_LEFT;

public class GPUMenu {
    public BorderPane createContent(Stage primaryStage, String nameText) {

        // Create the title text
        Text title = new Text("Choose your GPU method, " + nameText + "!");
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

        Font btnFont = null;
        try {
            btnFont = Font.loadFont(new File("src/main/java/com/example/corealproject/fonts/Inter-Bold.ttf").toURI().toURL().toExternalForm(), 16);
//            System.out.println(font);
        } catch (MalformedURLException e) {
//            System.out.println("aici");
            throw new RuntimeException(e);
        }


//        GPU_Benchmark gpu = new GPU_Benchmark();
        Button suta = new Button("Easy");
        suta.setOnAction(e -> {
            primaryStage.setScene(new Scene(new GPUTest(1).createContent(primaryStage, 1, nameText), 720, 420));

            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });
        suta.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), suta);
            st.setToX(1.1);
//            testButton.setBackground(Background.fill(Color.WHITE));
            suta.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: white; -fx-background-color: '#383838'");
            st.setToY(1.1);
            st.play();
        });
        suta.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), suta);
            st.setToX(1.0);
            suta.setBackground(Background.fill(Color.TRANSPARENT));
            suta.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
            st.setToY(1.0);
            st.play();
        });

        suta.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
        suta.setFont(mainTitleFont);
//        suta.setFill(Color.WHITE);
//        suta.setWrappingWidth(200);
        suta.setTextAlignment(TextAlignment.CENTER);

        VBox basicBox = new VBox(suta);
        basicBox.setMinHeight(150);
        basicBox.setMinWidth(150);
        basicBox.setMaxHeight(150);
        basicBox.setMaxWidth(150);

        basicBox.setStyle("-fx-border-color: '#383838'; -fx-border-width: 3px; -fx-border-radius: 30; -fx-text-fill: white;");
        basicBox.setAlignment(CENTER);
        basicBox.setSpacing(15);





        Button cincisute = new Button("Normal");
//        Button omie = new Button("1GB");
        cincisute.setOnAction(e -> {
            //start sequential testbench using 500MB
            primaryStage.setScene(new Scene(new GPUTest(3).createContent(primaryStage, 3, nameText), 720, 420));
//            gpu.gpuBench("2");
            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });

        cincisute.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), cincisute);
            st.setToX(1.1);
//            testButton.setBackground(Background.fill(Color.WHITE));
            cincisute.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: white; -fx-background-color: '#383838'");
            st.setToY(1.1);
            st.play();
        });
        cincisute.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), cincisute);
            st.setToX(1.0);
            cincisute.setBackground(Background.fill(Color.TRANSPARENT));
            cincisute.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
            st.setToY(1.0);
            st.play();
        });

        cincisute.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
        cincisute.setFont(mainTitleFont);
//        cincisute.setFill(Color.WHITE);
//        cincisute.setWrappingWidth(200);
        cincisute.setTextAlignment(TextAlignment.CENTER);

        VBox basicBox1 = new VBox(cincisute);
        basicBox1.setMinHeight(150);
        basicBox1.setMinWidth(150);
        basicBox1.setMaxHeight(150);
        basicBox1.setMaxWidth(150);

        basicBox1.setStyle("-fx-border-color: '#383838'; -fx-border-width: 3px; -fx-border-radius: 30; -fx-text-fill: white;");
        basicBox1.setAlignment(CENTER);
        basicBox1.setSpacing(15);


        Text rec = new Text("Recommended");
        rec.setFont(tagFont);
        rec.setFill(Color.WHITE);rec.setWrappingWidth(200);
        rec.setTextAlignment(TextAlignment.CENTER);

//        Button mieBtn = new Button("Start 1GB");

        Button omie = new Button("Hard");

        omie.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), omie);
            st.setToX(1.1);
//            testButton.setBackground(Background.fill(Color.WHITE));
            omie.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: white; -fx-background-color: '#383838'");
            st.setToY(1.1);
            st.play();
        });
        omie.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), omie);
            st.setToX(1.0);
            omie.setBackground(Background.fill(Color.TRANSPARENT));
            omie.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
            st.setToY(1.0);
            st.play();
        });

        omie.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
        omie.setFont(mainTitleFont);
//        omie.setFill(Color.WHITE);
//        omie.setWrappingWidth(200);
        omie.setTextAlignment(TextAlignment.CENTER);
        omie.setOnAction(e -> {
            //start sequential testbench using 1gb
            primaryStage.setScene(new Scene(new GPUTest(3).createContent(primaryStage, 3, nameText), 720, 420));
//            gpu.gpuBench("3");
            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });

        VBox basicBox2 = new VBox(omie, rec);
        basicBox2.setMinHeight(150);
        basicBox2.setMinWidth(150);
        basicBox2.setMaxHeight(150);
        basicBox2.setMaxWidth(150);

        basicBox2.setStyle("-fx-background-color: '#468ef2'; -fx-border-width: 3px; -fx-background-radius: 30; -fx-border-radius: 30; -fx-text-fill: white;");
        basicBox2.setAlignment(CENTER);
        basicBox2.setSpacing(15);


        // Create the Back button
        Button backButton = new Button("Back");
        backButton.setOnAction(e -> {
            primaryStage.setScene(new Scene(new Main().createContent(primaryStage), 720, 420));

            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });


        backButton.setFont(btnFont);

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




        // Create the layout
        HBox columns = new HBox(basicBox, basicBox1, basicBox2);
        columns.setSpacing(20);
        columns.setAlignment(CENTER);
        BorderPane root = new BorderPane(columns);
        root.setPadding(new Insets(20));
        HBox header = new HBox(backButton, title);
        header.setAlignment(CENTER_LEFT);
        header.setSpacing(20);
        root.setTop(header);
        BorderPane.setAlignment(title, CENTER);
        BorderPane.setAlignment(backButton, CENTER);

        return root;
    }
}

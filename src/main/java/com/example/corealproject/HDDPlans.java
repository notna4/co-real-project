package com.example.corealproject;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;

import static javafx.geometry.Pos.*;

public class HDDPlans {

    public BorderPane createContent(Stage primaryStage) {

        // Create the title text
        Text title = new Text("Choose HDD method");
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

        Text basicTitle = new Text("BASIC");
        basicTitle.setFont(tagFont);
        basicTitle.setFill(Color.WHITE);

        Text seqTitle = new Text("Sequential Read and Write");
        seqTitle.setFont(mainTitleFont);
        seqTitle.setFill(Color.WHITE);
        seqTitle.setWrappingWidth(200);

        Text prop1Seq = new Text("- primul lucru");
        Text prop2Seq = new Text("- al doilea lucru");
        Text prop3Seq = new Text("- al treilea lucru");

        prop1Seq.setFont(tagFont);
        prop2Seq.setFont(tagFont);
        prop3Seq.setFont(tagFont);

        prop1Seq.setFill(Color.WHITE);
        prop2Seq.setFill(Color.WHITE);
        prop3Seq.setFill(Color.WHITE);


        VBox benefitsSeq = new VBox(prop1Seq, prop2Seq, prop3Seq);
        benefitsSeq.setSpacing(10);


        VBox tagPart = new VBox(basicTitle);
        tagPart.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 50; -fx-text-fill: white; -fx-padding: 10; -fx-max-width: 30");
        VBox topPart = new VBox(tagPart, seqTitle);
        topPart.setAlignment(TOP_LEFT);
        topPart.setSpacing(15);
        Font btnFont = null;
        try {
            btnFont = Font.loadFont(new File("src/main/java/com/example/corealproject/fonts/Inter-Bold.ttf").toURI().toURL().toExternalForm(), 16);
//            System.out.println(font);
        } catch (MalformedURLException e) {
//            System.out.println("aici");
            throw new RuntimeException(e);
        }

        Button sequentialButton = new Button("Sequential");

        sequentialButton.setOnAction(e -> {
            primaryStage.setScene(new Scene(new SequentialMenu().createContent(primaryStage), 720, 420));

            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });

        sequentialButton.setFont(btnFont);
        sequentialButton.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), sequentialButton);
//            st.setToX(1.4);
//            sequentialButton.setBackground(Background.fill(Color.TRANSPARENT));
            sequentialButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: white; -fx-background-color: '#383838'");
//            st.setToY(1.1);
            st.play();
        });
        sequentialButton.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), sequentialButton);
//            st.setToX(1.0);
            sequentialButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
//            st.setToY(1.0);
            st.play();
        });

        sequentialButton.setPadding(new Insets(10));
        sequentialButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");

        VBox basicBox = new VBox(topPart, benefitsSeq, sequentialButton);
        VBox basicBoxcopy = new VBox(basicBox);
        basicBox.setMinHeight(300);
        basicBox.setMinWidth(250);
        basicBox.setMaxHeight(300);
        basicBox.setMaxWidth(250);

        basicBoxcopy.setMinHeight(300);
        basicBoxcopy.setMinWidth(270);
        basicBoxcopy.setMaxWidth(270);
        basicBoxcopy.setMaxHeight(300);

        basicBox.setStyle("-fx-border-color: '#383838'; -fx-border-width: 3px; -fx-border-radius: 30; -fx-text-fill: white; -fx-padding: 20");
        basicBoxcopy.setStyle("-fx-border-color: '#383838'; -fx-border-width: 3px; -fx-border-radius: 33; -fx-text-fill: white;");
        basicBoxcopy.setAlignment(TOP_LEFT);
        basicBox.setAlignment(TOP_LEFT);
        basicBox.setSpacing(15);


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

        backButton.setBackground(Background.fill(Color.WHITE));
        backButton.setPadding(new Insets(10));
        backButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");


        // Create the "Most popular" section
        Text popularTitle = new Text("Most popular");
        Button randomButton = new Button("Random");
        VBox popularBox = new VBox(popularTitle, randomButton);
        popularBox.setAlignment(CENTER);
        popularBox.setSpacing(10);


        Text basicTitle2 = new Text("MOST POPULAR");
        basicTitle2.setFont(tagFont);
        basicTitle2.setFill(Color.WHITE);

        Text rndTitle = new Text("Random Access Read and Write");
        rndTitle.setFont(mainTitleFont);
        rndTitle.setFill(Color.WHITE);
        rndTitle.setWrappingWidth(200);

        Text prop1Rnd = new Text("- algoritmu lui Gigi Becali");
        Text prop2Rnd = new Text("- al doilea lucru");
        Text prop3Rnd = new Text("- al treilea lucru");

        prop1Rnd.setFont(tagFont);
        prop2Rnd.setFont(tagFont);
        prop3Rnd.setFont(tagFont);

        prop1Rnd.setFill(Color.WHITE);
        prop2Rnd.setFill(Color.WHITE);
        prop3Rnd.setFill(Color.WHITE);


        VBox benefitsRnd = new VBox(prop1Rnd, prop2Rnd, prop3Rnd);
        benefitsRnd.setSpacing(10);



        VBox tagPart2 = new VBox(basicTitle2);
        tagPart2.setStyle("-fx-border-color: '#2971d6'; -fx-border-width: 2px; -fx-border-radius: 50; -fx-text-fill: white; -fx-padding: 10; -fx-max-width: 30");
        VBox topPart2 = new VBox(tagPart2, rndTitle);
        topPart2.setAlignment(TOP_LEFT);
        topPart2.setSpacing(15);

        Button rndButton = new Button("Random Access");
        rndButton.setFont(btnFont);
        rndButton.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), rndButton);
//            st.setToX(1.4);
//            sequentialButton.setBackground(Background.fill(Color.TRANSPARENT));
            rndButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: white; -fx-background-color: '#2971d6'");
//            st.setToY(1.1);
            st.play();
        });
        rndButton.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), rndButton);
//            st.setToX(1.0);
            rndButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
//            st.setToY(1.0);
            st.play();
        });

        rndButton.setPadding(new Insets(10));
        rndButton.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");

        VBox basicBox2 = new VBox(topPart2, benefitsRnd, rndButton);
        VBox basicBoxcopy2 = new VBox(basicBox2);
        basicBox2.setMinHeight(300);
        basicBox2.setMinWidth(250);
        basicBox2.setMaxHeight(300);
        basicBox2.setMaxWidth(250);

        basicBoxcopy2.setMinHeight(300);
        basicBoxcopy2.setMinWidth(260);
        basicBoxcopy2.setMaxWidth(260);
        basicBoxcopy2.setMaxHeight(300);

        basicBox2.setStyle("-fx-background-radius: 30; -fx-background-color: '#468ef2'; -fx-text-fill: white; -fx-padding: 20");
        basicBoxcopy2.setStyle("-fx-background-radius: 33; -fx-background-color: '#2971d6'; -fx-text-fill: white;");
        basicBoxcopy2.setAlignment(TOP_LEFT);
        basicBox2.setAlignment(TOP_LEFT);
        basicBox2.setSpacing(15);


        // Create the layout
        HBox columns = new HBox(basicBoxcopy, basicBoxcopy2);
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

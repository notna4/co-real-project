package com.example.corealproject;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.net.MalformedURLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Create the layout
        StackPane root = createContent(primaryStage);
        // Set the background color of the BorderPane
        root.setStyle("-fx-background-color: '#1e1e1e';");
        // Create the scene
        Scene scene = new Scene(root, 720, 420);

        // Set the scene on the primary stage and show it
        primaryStage.setTitle("CO Gaming");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public StackPane createContent(Stage primaryStage)  {


//        System.out.println(Font.loadFont("D:\\zweite\\coproject\\real\\co-real-project\\src\\main\\resources\\com\\example\\corealproject\\fonts\\Inter-Bold.ttf", 45));
        // Create the title text
        //Font.loadFont(new File("fonts/MyFont.ttf").toURI().toURL().toExternalForm(), 12);
        Font font = null;
        try {
            font = Font.loadFont(new File("src/main/java/com/example/corealproject/fonts/Inter-Bold.ttf").toURI().toURL().toExternalForm(), 30);
//            System.out.println(font);
        } catch (MalformedURLException e) {
//            System.out.println("aici");
            throw new RuntimeException(e);
        }
//        System.out.println(font.getFamily());
        Text title = new Text("CO Gaming Bench");
        title.setFont(font);
        title.setFill(Color.WHITE);


        // Create the "Test your HDD" button
        Button testButton = new Button("Test your HDD");
        testButton.setOnAction(e -> {
            primaryStage.setScene(new Scene(new HDDPlans().createContent(primaryStage), 720, 420));

            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });

        Button gpuTestBtn = new Button("Test your GPU");
        gpuTestBtn.setOnAction(e -> {
            primaryStage.setScene(new Scene(new GPUMenu().createContent(primaryStage), 720, 420));

            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });


        Font btnFont = null;
        try {
            btnFont = Font.loadFont(new File("src/main/java/com/example/corealproject/fonts/Inter-Bold.ttf").toURI().toURL().toExternalForm(), 15);
//            System.out.println(font);
        } catch (MalformedURLException e) {
//            System.out.println("aici");
            throw new RuntimeException(e);
        }
        testButton.setFont(btnFont);

        testButton.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), testButton);
            st.setToX(1.1);
//            testButton.setBackground(Background.fill(Color.WHITE));
            testButton.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 50; -fx-cursor: hand; -fx-text-fill: white");
            st.setToY(1.1);
            st.play();
        });
        testButton.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), testButton);
            st.setToX(1.0);
            testButton.setBackground(Background.fill(Color.TRANSPARENT));
            testButton.setStyle("-fx-border-color: '#383838'; -fx-border-width: 2px; -fx-border-radius: 50; -fx-cursor: hand; -fx-text-fill: white");
            st.setToY(1.0);
            st.play();
        });

        testButton.setBackground(Background.fill(Color.TRANSPARENT));
        testButton.setPadding(new Insets(10));
        testButton.setStyle("-fx-border-color: '#383838'; -fx-border-width: 2px; -fx-border-radius: 50; -fx-cursor: hand; -fx-text-fill: white");

        // -----
        gpuTestBtn.setFont(btnFont);

        gpuTestBtn.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), gpuTestBtn);
            st.setToX(1.1);
//            testButton.setBackground(Background.fill(Color.WHITE));
            gpuTestBtn.setStyle("-fx-border-color: white; -fx-border-width: 2px; -fx-border-radius: 50; -fx-cursor: hand; -fx-text-fill: white");
            st.setToY(1.1);
            st.play();
        });
        gpuTestBtn.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), gpuTestBtn);
            st.setToX(1.0);
            gpuTestBtn.setBackground(Background.fill(Color.TRANSPARENT));
            gpuTestBtn.setStyle("-fx-border-color: '#383838'; -fx-border-width: 2px; -fx-border-radius: 50; -fx-cursor: hand; -fx-text-fill: white");
            st.setToY(1.0);
            st.play();
        });

        gpuTestBtn.setBackground(Background.fill(Color.TRANSPARENT));
        gpuTestBtn.setPadding(new Insets(10));
        gpuTestBtn.setStyle("-fx-border-color: '#383838'; -fx-border-width: 2px; -fx-border-radius: 50; -fx-cursor: hand; -fx-text-fill: white");


        // Create the layout
        VBox vbox = new VBox(title, testButton, gpuTestBtn);
//        vbox.setStyle("-fx-text-fill: white");
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        BorderPane borderPane = new BorderPane(vbox);
        //Initialising path of the media file, replace this with your file path
        String path = "src/main/java/com/example/corealproject/bg.mp4";

        //Instantiating Media class
        Media media = new Media(new File(path).toURI().toString());

        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //Instantiating MediaView class
        MediaView mediaView = new MediaView(mediaPlayer);

        //by setting this property to true, the Video will be played
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        StackPane root = new StackPane(mediaView);

        //setting group and scene
        root.getChildren().add(borderPane);
//        StackPane root = new StackPane(borderPane);
        root.setPadding(new Insets(20));

        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }

}



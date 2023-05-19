package com.example.corealproject;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main extends Application {
    public String nameText;

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

    public StackPane createContent(Stage primaryStage) {


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
            primaryStage.setScene(new Scene(new HDDPlans().createContent(primaryStage, nameText), 720, 420));

            // Set the background color of the scene
            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';");
        });

        Button gpuTestBtn = new Button("Test your GPU");
        gpuTestBtn.setOnAction(e -> {
            primaryStage.setScene(new Scene(new GPUMenu().createContent(primaryStage, nameText), 720, 420));

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

        TextField textField = new TextField();
        textField.setPromptText("Enter your name");
        textField.setBackground(Background.fill(Color.WHITE));
        textField.setStyle("-fx-prompt-text-fill: #999999; -fx-font-style: italic; -fx-max-width: 200;  -fx-font-size: 20; -fx-background-radius: 50; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
//        textField.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
        testButton.setDisable(true);
        gpuTestBtn.setDisable(true);
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            nameText = textField.getText();
            if (newValue.isEmpty()) {
                // Set the border color to red if the TextField is empty
                testButton.setDisable(true);
                gpuTestBtn.setDisable(true);
                textField.setStyle("-fx-prompt-text-fill: #999999; -fx-font-style: italic; -fx-max-width: 200;  -fx-font-size: 20; -fx-background-radius: 50; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");

            } else {
                // Set the border color to green if the TextField has at least one character
                testButton.setDisable(false);
                gpuTestBtn.setDisable(false);
                textField.setStyle("-fx-prompt-text-fill: #999999; -fx-font-weight: 800; -fx-max-width: 200;  -fx-font-size: 20; -fx-background-radius: 50; -fx-text-fill: '#1e1e1e'; -fx-background-color: aquamarine");

            }
        });

        Button scoreBtn = new Button("Open Scores");

        scoreBtn.setFont(btnFont);

        scoreBtn.setOnMouseEntered(e -> {
            // Animate the button when the mouse enters
            ScaleTransition st = new ScaleTransition(Duration.millis(200), scoreBtn);
            st.setToX(1.1);
//            testButton.setBackground(Background.fill(Color.WHITE));
            scoreBtn.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: white; -fx-background-color: '#383838'");
            st.setToY(1.1);
            st.play();
        });
        scoreBtn.setOnMouseExited(e -> {
            // Animate the button when the mouse exits
            ScaleTransition st = new ScaleTransition(Duration.millis(200), scoreBtn);
            st.setToX(1.0);
            scoreBtn.setBackground(Background.fill(Color.TRANSPARENT));
            scoreBtn.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");
            st.setToY(1.0);
            st.play();
        });

        scoreBtn.setBackground(Background.fill(Color.WHITE));
        scoreBtn.setPadding(new Insets(10));
        scoreBtn.setStyle("-fx-background-radius: 50; -fx-cursor: hand; -fx-text-fill: '#1e1e1e'; -fx-background-color: white");


        scoreBtn.setOnAction(event -> {
            Stage scoreStage = new Stage();
            scoreStage.initModality(Modality.APPLICATION_MODAL);
            scoreStage.setTitle("Scores");

            Label header = new Label("Scores");
            Text subHeader = new Text("Click columns for sorting");
            header.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
            header.setPrefWidth(200);

            TableView<Score> scoreTable = new TableView<>();
            scoreTable.setStyle("-fx-padding: 20;");

            TableColumn<Score, String> methodCol = new TableColumn<>("Method");
            methodCol.setCellValueFactory(new PropertyValueFactory<>("method"));
            methodCol.setSortable(true);

            TableColumn<Score, String> nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            nameCol.setSortable(true);

            TableColumn<Score, Double> scoreCol = new TableColumn<>("Score");
            scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
            scoreCol.setSortable(true);

            TableColumn<Score, Integer> sizeCol = new TableColumn<>("Size");
            sizeCol.setCellValueFactory(new PropertyValueFactory<>("size"));
            sizeCol.setSortable(true);

            TableColumn<Score, String> dateCol = new TableColumn<>("Date");
            dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
            dateCol.setSortable(true);

            scoreTable.getColumns().addAll(methodCol, nameCol, scoreCol, sizeCol,dateCol);

            ObservableList<Score> scores = FXCollections.observableArrayList(readScoresFromFile());
            scores.sort(Comparator.comparing(Score::getScore));

            scoreTable.setItems(scores);

            ScrollPane scrollPane = new ScrollPane(scoreTable);
            scrollPane.setFitToWidth(true);

//            VBox root = new VBox(header, subHeader, scrollPane);

            String path = "src/main/java/com/example/corealproject/bg.mp4";

            //Instantiating Media class
//            Media media = new Media(new File(path).toURI().toString());

            Media media = new Media(new File("file:///home/cristicanceal/IdeaProjects/co-real-project/src/main/java/com/example/corealproject/bg.mp4").toURI().toString());

            //Instantiating MediaPlayer class
//            MediaPlayer mediaPlayer = new MediaPlayer(media);

            //Instantiating MediaView class
//            MediaView mediaView = new MediaView(mediaPlayer);

            //by setting this property to true, the Video will be played
//            mediaPlayer.setAutoPlay(true);
//            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            StackPane root = new StackPane(header, subHeader, scrollPane);

            //setting group and scene
//            root.getChildren().add(borderPane);



//            root.setSpacing(20);
            root.setStyle("-fx-padding: 20;");

            Scene scoreScene = new Scene(root, 500, 420);
            scoreStage.setScene(scoreScene);
            scoreStage.show();
        });


        // Create the layout
        VBox vbox = new VBox(title, textField, testButton, gpuTestBtn, scoreBtn);
//        vbox.setStyle("-fx-text-fill: white");
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(20);
        BorderPane borderPane = new BorderPane(vbox);
        //Initialising path of the media file, replace this with your file path
        String path = "src/main/java/com/example/corealproject/bg.mp4";

        //Instantiating Media class
//        Media media = new Media(new File(path).toURI().toString());
//        Media media = new Media(new File("file:///home/cristicanceal/IdeaProjects/co-real-project/src/main/java/com/example/corealproject/bg.mp4").toURI().toString());

        //Instantiating MediaPlayer class
//        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //Instantiating MediaView class
//        MediaView mediaView = new MediaView(mediaPlayer);

        //by setting this property to true, the Video will be played
//        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

        StackPane root = new StackPane();

        //setting group and scene
        root.getChildren().add(borderPane);
//        StackPane root = new StackPane(borderPane);
        root.setPadding(new Insets(20));

        return root;
    }

    private List<Score> readScoresFromFile() {
        List<Score> scores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("ScoreHistoryHDDRandom.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String method = parts[0].trim();
                String name = parts[1].trim();
                String date = parts[2].trim();
                int size = Integer.parseInt(parts[4].trim());
                double score = Double.parseDouble(parts[parts.length - 2].trim());
                Score s = new Score(method, name, score, size, date);
                scores.add(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public static class Score {
        private final SimpleStringProperty name;
        private final SimpleStringProperty method;
        private final SimpleDoubleProperty score;

        private final SimpleIntegerProperty size;
        private final SimpleStringProperty date;

        public Score(String method, String name, double score, int size, String date) {
            this.name = new SimpleStringProperty(name);
            this.method = new SimpleStringProperty(method);
            this.size = new SimpleIntegerProperty(size);
            this.score = new SimpleDoubleProperty(score);
            this.date = new SimpleStringProperty(date);
        }

        public String getName() {
            return name.get();
        }

        public String getMethod() {
            return method.get();
        }

        public int getSize() {
            return size.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public double getScore() {
            return score.get();
        }

        public void setScore(double score) {
            this.score.set(score);
        }

        public String getDate() {
            return date.get();
        }

        public void setDate(String date) {
            this.date.set(date);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}



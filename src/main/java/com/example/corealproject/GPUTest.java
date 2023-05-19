package com.example.corealproject;

import GPU.GPU_Benchmark;
import HDD.RandAccess.RandomReadWriteImproved;
import HDD.RandAccess.RandomReadWriteMain;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static javafx.geometry.Pos.CENTER;
import static javafx.geometry.Pos.CENTER_LEFT;
import static javafx.scene.layout.BorderPane.setAlignment;

public class GPUTest {

    public int size;
    private final BooleanProperty fullScreenMode = new SimpleBooleanProperty(false);
    private static final String FILE_NAME = "ScoreHistoryHDDRandom.txt";

    public GPUTest(int mode) {
        System.out.println("mode: " + mode);
    }

    public BorderPane createContent(Stage primaryStage, int mode, String nameText) {

        String m = "";

        if(mode == 1) {
            m = "easy";
        }
        else if(mode == 2) {
            m = "normal";
        }
        else if(mode == 3) {
            m = "hard";
        }

        Text title = new Text("GPU test: " + m);
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

        // Create an HBox to hold the ImageViews
        HBox hbox = new HBox(10); // Adjust the spacing between the images as needed


        // Create the Start button
        Button startButton = new Button("Start");
        startButton.setOnAction(e -> {
//            primaryStage.setScene(new Scene(new HDDPlans().createContent(primaryStage), 720, 420));
//            System.out.println("startttt");
            startButton.setDisable(true);
            backButton.setDisable(true);
            startButton.setText("Computing..");
            GPU_Benchmark gpu = new GPU_Benchmark();

//            System.out.println(String.valueOf(mode));

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(2), event -> {
                        gpu.gpuBench(String.valueOf(mode));
                    })
            );
            timeline.play();
            // Set the background color of the scene
//            primaryStage.getScene().getRoot().setStyle("-fx-background-color: '#1e1e1e';")

//            gpu.gpuBench(String.valueOf(mode));

//            results.setText(String.valueOf(scor));


            // Wait for 2 seconds and show the button again
            Timeline timeline0 = new Timeline(
                    new KeyFrame(Duration.seconds(2), event -> {
                        startButton.setDisable(false);
                        backButton.setDisable(false);
                        startButton.setText("Start again");
                        title.setText("Click on the image :)");

                        String scoreFile = "score.txt"; // Replace with the actual file name
                        Path scorePath = Paths.get(scoreFile);
                        String scoreResult = "";
                        String[] timeResults = new String[2];
                        int i = 0;
                        try {
                            // Read file contents
                            scoreResult = Files.readString(scorePath);
//                            System.out.println(scoreResult);
                            // Perform further operations with the file content

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        String timeFile = "time.txt"; // Replace with the actual file name
                        Path timePath = Paths.get(timeFile);

                        BufferedReader reader = null;

                        try {
                            // Specify the file path

                            // Create a FileReader and wrap it in a BufferedReader
                            reader = new BufferedReader(new FileReader(timeFile));

                            String line;
                            // Read each line of the file until the end
                            while ((line = reader.readLine()) != null) {
                               timeResults[i++] = line;
                            }
                        } catch (IOException er) {
                            er.printStackTrace();
                        } finally {
                            // Close the reader
                            try {
                                if (reader != null) {
                                    reader.close();
                                }
                            } catch (IOException er) {
                                er.printStackTrace();
                            }
                        }

                        results.setText("Score: " + scoreResult + " | " + "Time for leaf: " + timeResults[0] + "s. | Time for mandelbrot: " + timeResults[1] + "s.");


                        try {
                            FileWriter text = new FileWriter(FILE_NAME,true);
                            LocalDateTime now = LocalDateTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                            String formattedTime = now.format(formatter);
                            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                                writer.write("GPU" + "," + nameText+ "," + formattedTime + "," + scoreResult+","+mode+"\n");
                            } catch (IOException err) {
                                err.printStackTrace();
                            }
                            text.close();
                            System.out.println("Score posted!");
                        } catch (IOException err) {
                            System.out.println("Could not post score,error occured!");
                            err.printStackTrace();
                        }


                        String IMAGE_FOLDER = "/home/cristicanceal/IdeaProjects/co-real-project";
                        String IMAGE1_NAME = "/home/cristicanceal/IdeaProjects/co-real-project/leaf.png";
                        String IMAGE2_NAME = "/home/cristicanceal/IdeaProjects/co-real-project/mandelbrot.png";

                        // Load the images
                        Image image1 = new Image("file:" + IMAGE1_NAME);
                        Image image2 = new Image("file:" + IMAGE2_NAME);


                        // Create ImageViews to display the images
                        ImageView imageView1 = createImageView(image1);
                        ImageView imageView2 = createImageView(image2);


                        imageView1.setFitWidth(800);
                        imageView1.setFitHeight(800);
                        imageView2.setFitWidth(800);
                        imageView2.setFitHeight(800);


                        hbox.setAlignment(Pos.CENTER);
                        hbox.setPadding(new Insets(10));
                        hbox.getChildren().addAll(imageView1, imageView2);


                    })
            );
            timeline0.play();
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



//        HBox col = new HBox(startButton, results);

        // Create the layout
        HBox columns = new HBox(backButton, hbox);
        columns.setSpacing(20);

        columns.setAlignment(CENTER);
        BorderPane root = new BorderPane(columns);
        root.setPadding(new Insets(20));
        HBox header = new HBox(backButton, title, startButton, results);
        header.setAlignment(CENTER_LEFT);
        header.setSpacing(20);
        root.setTop(header);
        setAlignment(title, CENTER);
        setAlignment(backButton, CENTER);

        return root;
    }

    private ImageView createImageView(Image image) {
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                toggleFullScreen(imageView);
            }
        });
        return imageView;
    }

    private void toggleFullScreen(ImageView imageView) {
        Stage stage = (Stage) imageView.getScene().getWindow();

        if (!fullScreenMode.get()) {
            stage.setFullScreen(true);
            fullScreenMode.set(true);
        } else {
            stage.setFullScreen(false);
            fullScreenMode.set(false);
        }
    }
}

module com.example.corealproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.corealproject to javafx.fxml;
    exports com.example.corealproject;
}
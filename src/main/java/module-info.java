module com.example.corealproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires org.kordamp.bootstrapfx.core;


    opens com.example.corealproject to javafx.fxml;
    exports com.example.corealproject;
}
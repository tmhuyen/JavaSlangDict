module com.example.slangproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.slangproject to javafx.fxml;
    exports com.example.slangproject;
}
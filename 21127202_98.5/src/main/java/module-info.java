module slangproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.module.slangproject to javafx.fxml;
    exports com.module.slangproject;
}
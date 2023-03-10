module com.example.fxmljavafxlaba {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.sql;


    opens com.example.fxmljavafxlaba to javafx.fxml;
    exports com.example.fxmljavafxlaba;
}
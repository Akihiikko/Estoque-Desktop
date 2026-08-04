module com.jociel.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.amanda.estoque to javafx.fxml;
    exports com.amanda.estoque;
}
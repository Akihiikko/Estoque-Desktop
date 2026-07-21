module com.jociel.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.jociel.estoque to javafx.fxml;
    exports com.jociel.estoque;
}
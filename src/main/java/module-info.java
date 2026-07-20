module com.jociel.estoque {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.jociel.estoque to javafx.fxml;
    exports com.jociel.estoque;
}
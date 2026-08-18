module com.jociel.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;


    opens com.amanda.estoque to javafx.fxml;
    exports com.amanda.estoque;
    exports com.amanda.estoque.Controller;
    opens com.amanda.estoque.Controller to javafx.fxml;
}
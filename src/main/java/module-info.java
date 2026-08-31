module com.amanda.estoque {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.ikonli.materialdesign2;
    requires java.sql;
    requires jbcrypt;


    opens com.amanda.estoque to javafx.fxml;
    exports com.amanda.estoque;
    exports com.amanda.estoque.Controller;
    opens com.amanda.estoque.Controller to javafx.fxml;
    opens com.amanda.estoque.model to javafx.base;
}
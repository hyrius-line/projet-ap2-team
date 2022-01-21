module fr.thibaut2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens fr.thibaut2 to javafx.fxml;
    exports fr.thibaut2;
}

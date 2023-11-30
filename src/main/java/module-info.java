module com.example.teachersms {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    exports com.example.teachersms;
    exports sources;

    opens com.example.teachersms to
            javafx.fxml;
    opens sources to
            javafx.fxml;
}
module com.example.teachersms {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    exports com.example.teachersms;
    exports engine;

    opens com.example.teachersms to
            javafx.fxml;
    opens engine to
            javafx.fxml;
}
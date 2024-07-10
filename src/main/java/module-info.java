module com.example.chatapplication {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.sql;

    opens com.example.chatapplication to javafx.fxml;
    exports com.example.chatapplication;
}
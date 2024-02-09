module com.example.projectpi {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projectpi to javafx.fxml;
    exports com.example.projectpi;
}
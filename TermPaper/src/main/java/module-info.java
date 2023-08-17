module com.example.termpaper {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.microsoft.sqlserver.jdbc;


    opens com.example.termpaper to javafx.fxml;
    exports com.example.termpaper;
}
module com.example.demoview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demoview to javafx.fxml;
    exports com.example.demoview;

}
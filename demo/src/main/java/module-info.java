module com.example.demojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demo.controles to javafx.fxml;
    exports com.example.demo.controles;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
}
module com.example.calculadoraimc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.calculadoraimc to javafx.fxml;
    exports com.example.calculadoraimc;
}
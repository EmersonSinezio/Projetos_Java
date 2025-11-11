module com.example.relogiodigital {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.relogiodigital to javafx.fxml;
    exports com.example.relogiodigital;
}
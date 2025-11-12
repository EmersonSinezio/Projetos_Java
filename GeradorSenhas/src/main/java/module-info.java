module com.example.geradorsenhas {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.geradorsenhas to javafx.fxml;
    exports com.example.geradorsenhas;
}
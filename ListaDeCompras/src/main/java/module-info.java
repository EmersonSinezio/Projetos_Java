module org.example.listadecompras {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.listadecompras to javafx.fxml;
    exports org.example.listadecompras;
}
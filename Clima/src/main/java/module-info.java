module org.example.clima {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;
    requires java.dotenv;


    opens org.example.clima to javafx.fxml;
    exports org.example.clima;
}
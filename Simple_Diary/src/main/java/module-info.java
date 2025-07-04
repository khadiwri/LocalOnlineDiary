module com.example.simple_diary {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.simple_diary to javafx.fxml;
    exports com.example.simple_diary;
}
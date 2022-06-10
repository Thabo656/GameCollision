module com.example.gamecollision {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.gamecollision to javafx.fxml;
    exports com.example.gamecollision;
}
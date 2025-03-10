module com.arikko.radio_button {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.arikko.radio_button to javafx.fxml;
    exports com.arikko.radio_button;
}
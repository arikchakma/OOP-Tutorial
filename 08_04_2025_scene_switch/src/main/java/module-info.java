module com.arikko.scene_switch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arikko.scene_switch to javafx.fxml;
    exports com.arikko.scene_switch;
}
module com.arikko.demo_tutorial {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arikko.demo_tutorial to javafx.fxml;
    exports com.arikko.demo_tutorial;
}
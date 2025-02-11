module com.arikko.loginform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arikko.loginform to javafx.fxml;
    exports com.arikko.loginform;
}
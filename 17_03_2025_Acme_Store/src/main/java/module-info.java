module com.arikko.acme_store {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arikko.acme_store to javafx.fxml;
    exports com.arikko.acme_store;
    exports com.arikko.acme_store.users;
    opens com.arikko.acme_store.users to javafx.fxml;
}
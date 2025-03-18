package com.arikko.acme_store;

import com.arikko.acme_store.controllers.LoginViewController;
import com.arikko.acme_store.users.Admin;
import com.arikko.acme_store.users.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // init all dummy database array list
        ArrayList<User> users = new ArrayList<>();

        User dummyAdminUser = new Admin(1111, "Arik", "Chakma", "arikchangma@gmail.com", "arik112233", "+8801xxxx");
        users.add(dummyAdminUser);

        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("LoginView.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Acme Store");
        stage.setScene(scene);

        LoginViewController loginViewController = (LoginViewController) fxmlLoader.getController();
        loginViewController.setUsers(users);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
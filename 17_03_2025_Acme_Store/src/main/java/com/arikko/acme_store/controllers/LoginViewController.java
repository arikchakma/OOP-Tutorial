package com.arikko.acme_store.controllers;

import com.arikko.acme_store.MainApplication;
import com.arikko.acme_store.product.Product;
import com.arikko.acme_store.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class LoginViewController {
    @javafx.fxml.FXML
    private CheckBox showPasswordCheckBox;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;

    // dummy local database
    private ArrayList<User> users;
    private ArrayList<Product> products;

    public void setDummyDb(ArrayList<User> users, ArrayList<Product> products) {
        this.users = users;
        this.products = products;
    }

    @javafx.fxml.FXML
    private Label showPasswordLabel;

    @javafx.fxml.FXML
    public void initialize() {
        showPasswordLabel.setOpacity(0);
    }


    @javafx.fxml.FXML
    public void signUpOnAction(ActionEvent actionEvent) {
        // scene switch to registration view
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        try {
            FXMLLoader registrationFxmlLoader = new FXMLLoader(
                    MainApplication.class.getResource("RegistrationView.fxml")
            );

            Scene registrationScene = new Scene(registrationFxmlLoader.load());
            stage.setScene(registrationScene);
            RegistrationViewController registrationViewController = (RegistrationViewController) registrationFxmlLoader.getController();
            registrationViewController.setDummyDb(this.users, this.products);
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void loginContinueOnAction(ActionEvent actionEvent) {
        String email = emailTextField.getText();
        String password = passwordPasswordField.getText();

        boolean isValidEmailAndPassword = User.validateEmailAndPassword(email, password);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (!isValidEmailAndPassword) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Email or Password");
            alert.setContentText("Please use valid email and password. Password must be longer than 6, and must contain a number");
            alert.showAndWait();
            return;
        }

        User currentUser = User.verifyUser(users, email, password);
        if (currentUser == null) {
            alert.setHeaderText("Invalid Email or Password");
            alert.setContentText("Please use valid email and password.");
            alert.showAndWait();
            return;
        }

        emailTextField.clear();
        passwordPasswordField.clear();

        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        try {
            FXMLLoader layoutFxmlLoader = new FXMLLoader(
                    MainApplication.class.getResource("LayoutView.fxml")
            );

            Scene layoutScene = new Scene(layoutFxmlLoader.load());
            stage.setScene(layoutScene);
            LayoutViewController layoutViewController = (LayoutViewController) layoutFxmlLoader.getController();
            layoutViewController.setDummyDb(this.users, this.products);
            layoutViewController.setCurrentUser(currentUser);
        } catch (Exception e) {
        }
    }

    @javafx.fxml.FXML
    public void showPasswordOnAction(ActionEvent actionEvent) {
        if (showPasswordCheckBox.isSelected()) {
            String password = passwordPasswordField.getText();
            showPasswordLabel.setText(password);
            showPasswordLabel.setOpacity(100);
        } else {
            showPasswordLabel.setText("");
            showPasswordLabel.setOpacity(0);
        }
    }
}
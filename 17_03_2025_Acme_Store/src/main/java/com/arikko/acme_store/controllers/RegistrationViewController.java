package com.arikko.acme_store.controllers;

import com.arikko.acme_store.MainApplication;
import com.arikko.acme_store.users.Customer;
import com.arikko.acme_store.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class RegistrationViewController
{
    @javafx.fxml.FXML
    private TextField phoneNumberTextField;
    @javafx.fxml.FXML
    private TextField lastNameTextField;
    @javafx.fxml.FXML
    private TextField emailTextField;
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private TextField firstNameTextField;

    // dummy local database
    private ArrayList<User> users;

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void createAccountOnAction(ActionEvent actionEvent) {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String email = emailTextField.getText();
        String password = passwordPasswordField.getText();
        String phoneNumber = phoneNumberTextField.getText();

        boolean isValidEmailAndPassword = User.validateEmailAndPassword(email, password);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (!isValidEmailAndPassword) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid Email or Password");
            alert.setContentText("Please use valid email and password. Password must be longer than 6, and must contain a number");
            alert.showAndWait();
            return;
        }

        boolean alreadyExistsUser = false;
        for (User u: users) {
            if (u.getEmail().equals(email)) {
                alreadyExistsUser = true;
                break;
            }
        }

        if (alreadyExistsUser) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("You already have an account");
            alert.setContentText("Please use a different email or login to you account");
            alert.showAndWait();
            return;
        }

        int newId = Customer.generateCustomerId(this.users);
        User newCustomer = new Customer(newId, firstName, lastName, email,password, phoneNumber);
        this.users.add(newCustomer);

        firstNameTextField.clear();
        lastNameTextField.clear();
        emailTextField.clear();
        passwordPasswordField.clear();
        phoneNumberTextField.clear();

        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Account Created!!");
        alert.show();

        loginOnAction(actionEvent);
    }

    @javafx.fxml.FXML
    public void loginOnAction(ActionEvent actionEvent) {
        Scene scene = ((Button) actionEvent.getSource()).getScene();
        Stage stage = (Stage) scene.getWindow();

        try {
            FXMLLoader loginFxmlLoader = new FXMLLoader(
                    MainApplication.class.getResource("LoginView.fxml")
            );

            Scene loginScene = new Scene(loginFxmlLoader.load());
            stage.setScene(loginScene);
            LoginViewController loginViewController = (LoginViewController) loginFxmlLoader.getController();
            loginViewController.setUsers(this.users);
        } catch (Exception e) {
        }
    }
}
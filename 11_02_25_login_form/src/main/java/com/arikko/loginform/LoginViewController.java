package com.arikko.loginform;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;

public class LoginViewController
{
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private TextField usernameTextField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void passwordOnKeyTyped(Event event) {
        String password = passwordPasswordField.getText();
        int password_length = password.length();
        if(password_length < 6) {
            passwordPasswordField.setStyle("-fx-border-color: red");
        } else {
            passwordPasswordField.setStyle("-fx-border-color: green");
        }
    }

    @javafx.fxml.FXML
    public void loginOnAction(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(username.length() < 4) {
            alert.setTitle("Username must be longer than 4");
            alert.showAndWait();
            return;
        }

        String password = passwordPasswordField.getText();
        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        boolean hasNumber = false;
        // 123345 => 1, 2, 3, 4
        // a.b.c.d => split(".") => a, b, c, d
        // abcd1234 => split("") => a,b,c,d,1,2,3,4
        for (String number: numbers) {
            if(password.contains(number)) {
                hasNumber = true;
            }
        }

        if(!hasNumber || password.length() < 6) {
            alert.setHeaderText("Password Error");
            alert.setContentText("Password must be longer than 6 and must contain a number.");
            alert.showAndWait();
            return;
        }


        String admin_password = "admin123";
        String admin_username = "admin007";
        if(!(username.equals(admin_username) && password.equals(admin_password))) {
            alert.setHeaderText("Wrong username or password!");
            alert.setContentText("Your username or password is incorrect!");
            alert.showAndWait();
            return;
        }

        usernameTextField.clear();
        passwordPasswordField.clear();
        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Login Successful");
        alert.setContentText("Welcome back, " + username);
        alert.showAndWait();
    }
}
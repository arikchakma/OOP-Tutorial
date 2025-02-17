package com.arikko.loginform;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.*;

import java.util.ArrayList;

public class LoginViewController {
    @javafx.fxml.FXML
    private PasswordField passwordPasswordField;
    @javafx.fxml.FXML
    private TextField usernameTextField;
    @javafx.fxml.FXML
    private TextField registerUsernameTextField;
    @javafx.fxml.FXML
    private PasswordField registerPasswordTextField;
    @javafx.fxml.FXML
    private TextField registerNameTextField;

    boolean hasUpdatedUsername = false;
    // temp database
    ArrayList<User> users;

    @javafx.fxml.FXML
    public void initialize() {
        users = new ArrayList<User>();
    }

    @javafx.fxml.FXML
    public void passwordOnKeyTyped(Event event) {
        String password = passwordPasswordField.getText();
        int password_length = password.length();
        if (password_length < 6) {
            passwordPasswordField.setStyle("-fx-border-color: red");
        } else {
            passwordPasswordField.setStyle("-fx-border-color: green");
        }
    }

    @javafx.fxml.FXML
    public void loginOnAction(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        String password = passwordPasswordField.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);

        boolean isValidCred = this.validateUsernameAndPassword(username, password);
        if (!isValidCred) {
            alert.setTitle("Incorrect Credentials");
            alert.setContentText("Username must be longer than 4, password must be longer than 6, and must contain a number");
            alert.showAndWait();
            return;
        }

        User current_user = null;
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                current_user = u;
                break;
            }
        }

        if (current_user == null) {
            alert.setHeaderText("Wrong username or password!");
            alert.setContentText("Your username or password is incorrect!");
            alert.showAndWait();
            return;
        }

        usernameTextField.clear();
        passwordPasswordField.clear();

        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Login Successful");
        alert.setContentText("Welcome back, " + current_user.getName());
        alert.showAndWait();
    }

    private boolean validateUsernameAndPassword(String username, String pwd) {
        if (username.length() < 4) {
            return false;
        }

        String[] numbers = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        boolean hasNumber = false;
        // 123345 => 1, 2, 3, 4
        // a.b.c.d => split(".") => a, b, c, d
        // abcd1234 => split("") => a,b,c,d,1,2,3,4
        for (String number : numbers) {
            if (pwd.contains(number)) {
                hasNumber = true;
            }
        }

        if (!hasNumber || pwd.length() < 6) {
            return false;
        }

        return true;
    }

    @javafx.fxml.FXML
    public void createUserOnAction(ActionEvent actionEvent) {
        String name = registerNameTextField.getText();
        String username = registerUsernameTextField.getText();
        String password = registerPasswordTextField.getText();

        Alert alert = new Alert(Alert.AlertType.ERROR);

        boolean isValidCred = this.validateUsernameAndPassword(username, password);
        if (!isValidCred) {
            alert.setTitle("Incorrect Credentials");
            alert.setContentText("Username must be longer than 4, password must be longer than 6, and must contain a number");
            alert.showAndWait();
            return;
        }

        for (User u : users) {
            if (u.getUsername().equals(username)) {
                alert.setTitle("Username not available.");
                alert.showAndWait();
                return;
            }
        }

        User new_user = new User(username, name, password);
        users.add(new_user);

        registerNameTextField.clear();
        registerUsernameTextField.clear();
        registerPasswordTextField.clear();

        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setTitle("You have successfully created an account!");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void nameOnKeyTyped(Event event) {
        if (hasUpdatedUsername) {
            return;
        }

        String created_user_name = registerNameTextField.getText()
                .toLowerCase()
                // replace the spaces with empty string
                .replaceAll(" ", "");

        registerUsernameTextField.setText(created_user_name);
    }

    @javafx.fxml.FXML
    public void usernameOnKeyTyped(Event event) {
        hasUpdatedUsername = true;
    }
}
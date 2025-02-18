package com.arikko.loginform;

import javafx.collections.ObservableList;
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
    private Tab dashbaordTab;
    @javafx.fxml.FXML
    private Tab registerTab;
    @javafx.fxml.FXML
    private Label usernameLabel;
    @javafx.fxml.FXML
    private Tab loginTab;
    @javafx.fxml.FXML
    private Label nameLabel;

    User current_logged_in_user = null;
    User selected_profile_user = null;

    @javafx.fxml.FXML
    private TabPane mainTabPane;
    @javafx.fxml.FXML
    private Label profileNameLabel;
    @javafx.fxml.FXML
    private Label profileUsernameLabel;
    @javafx.fxml.FXML
    private ComboBox<String> usersCombobox;
    @javafx.fxml.FXML
    private Tab profileTab;
    @javafx.fxml.FXML
    private Button addFriendButton;
    @javafx.fxml.FXML
    private Button removeFriendButton;

    @javafx.fxml.FXML
    public void initialize() {
        users = new ArrayList<User>();
        dashbaordTab.setDisable(true);
        profileTab.setDisable(true);

        users.add(new User("arikchakma", "Arik Chakma", "Arik112233", new ArrayList<>()));
        users.add(new User("john", "John", "Arik112233", new ArrayList<>()));
        users.add(new User("kamran", "Kamran", "Arik112233", new ArrayList<>()));
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

        current_logged_in_user = current_user;
        dashbaordTab.setDisable(false);
        profileTab.setDisable(false);
        nameLabel.setText(current_logged_in_user.getName());
        usernameLabel.setText(current_logged_in_user.getUsername());

        usersCombobox.getItems().clear();
        for (User u : users) {
            if (!u.getUsername().equals(current_user.getUsername())) {
                String key = u.getName() + "--" + u.getUsername();
                usersCombobox.getItems().add(key);
            }
        }

        SingleSelectionModel<Tab> singleSelectionModel = mainTabPane.getSelectionModel();
        singleSelectionModel.select(dashbaordTab);
        loginTab.setDisable(true);
        registerTab.setDisable(true);
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

        // TODO: custom logic for the terms check

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

        User new_user = new User(username, name, password, new ArrayList<>());
        users.add(new_user);
        String key = new_user.getName() + "--" + new_user.getUsername();
        usersCombobox.getItems().add(key);

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

    @javafx.fxml.FXML
    public void logoutOnAction(ActionEvent actionEvent) {
        current_logged_in_user = null;

        loginTab.setDisable(false);
        registerTab.setDisable(false);
        dashbaordTab.setDisable(true);
        profileTab.setDisable(true);

        SingleSelectionModel<Tab> singleSelectionModel = mainTabPane.getSelectionModel();
        singleSelectionModel.select(loginTab);
    }

    @javafx.fxml.FXML
    public void goToProfileOnAction(ActionEvent actionEvent) {
        String[] keys = usersCombobox.getValue().split("--");
        String username = keys[1];

        selected_profile_user = null;
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                selected_profile_user = u;
                break;
            }
        }

        if (selected_profile_user == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("User doesn't exist");
            alert.showAndWait();
            return;
        }

        profileNameLabel.setText(selected_profile_user.getName());
        profileUsernameLabel.setText(selected_profile_user.getUsername());

        ArrayList<User> current_user_friends = current_logged_in_user.getFriends();

        boolean is_selected_user_a_friend = false;
        for (User f : current_user_friends) {
            if (f.getUsername().equals(selected_profile_user.getUsername())) {
                is_selected_user_a_friend = true;
                break;
            }
        }

        if (is_selected_user_a_friend) {
            addFriendButton.setDisable(true);
            removeFriendButton.setDisable(false);
        } else {
            addFriendButton.setDisable(false);
            removeFriendButton.setDisable(true);
        }

        SingleSelectionModel<Tab> singleSelectionModel = mainTabPane.getSelectionModel();
        singleSelectionModel.select(profileTab);
    }

    @javafx.fxml.FXML
    public void removeFriendOnAction(ActionEvent actionEvent) {
        current_logged_in_user.getFriends().remove(selected_profile_user);
        selected_profile_user.getFriends().remove(current_logged_in_user);

        addFriendButton.setDisable(false);
        removeFriendButton.setDisable(true);
    }

    @javafx.fxml.FXML
    public void addFriendOnAction(ActionEvent actionEvent) {
        current_logged_in_user.getFriends().add(selected_profile_user);
        selected_profile_user.getFriends().add(current_logged_in_user);

        addFriendButton.setDisable(true);
        removeFriendButton.setDisable(false);
    }
}
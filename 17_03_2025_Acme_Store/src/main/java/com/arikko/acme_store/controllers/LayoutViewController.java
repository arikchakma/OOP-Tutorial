package com.arikko.acme_store.controllers;

import com.arikko.acme_store.users.User;
import javafx.event.ActionEvent;
import javafx.scene.control.Menu;

import java.util.ArrayList;

public class LayoutViewController
{
    @javafx.fxml.FXML
    private Menu adminMenu;
    @javafx.fxml.FXML
    private Menu customerMenu;

    // dummy local database
    private ArrayList<User> users;
    private User currentUser = null;


    @javafx.fxml.FXML
    public void initialize() {
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        String currentUserType = currentUser.getType();
        adminMenu.setVisible(currentUserType.equals("admin"));
        customerMenu.setVisible(currentUserType.equals("customer"));
    }

    @javafx.fxml.FXML
    public void adminUpdateUserOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void adminAllProductsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerDashboardOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void adminCreateProductOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerCardOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void customerAllProductsOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void adminOrdersOnAction(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void adminDeleteProductOnAction(ActionEvent actionEvent) {
    }
}
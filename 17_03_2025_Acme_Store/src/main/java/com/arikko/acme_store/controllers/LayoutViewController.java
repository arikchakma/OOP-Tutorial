package com.arikko.acme_store.controllers;

import com.arikko.acme_store.MainApplication;
import com.arikko.acme_store.product.Product;
import com.arikko.acme_store.users.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;

public class LayoutViewController
{
    @javafx.fxml.FXML
    private Menu adminMenu;
    @javafx.fxml.FXML
    private Menu customerMenu;

    @javafx.fxml.FXML
    private BorderPane layoutViewBorderpane;


    @javafx.fxml.FXML
    public void initialize() {
    }

    // dummy local database
    private User currentUser = null;
    private ArrayList<User> users;
    private ArrayList<Product> products;

    public void setDummyDb(ArrayList<User> users, ArrayList<Product> products) {
        this.users = users;
        this.products = products;
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
        try {
            FXMLLoader createProductFxmlLoader = new FXMLLoader(
                    MainApplication.class.getResource("CreateProductView.fxml")
            );

            layoutViewBorderpane.setCenter(createProductFxmlLoader.load());
            CreateProductViewController createProductViewController = (CreateProductViewController) createProductFxmlLoader.getController();
            createProductViewController.setDummyDb(this.users, this.products);
            createProductViewController.setCurrentUser(currentUser);
        } catch (Exception e) {
        }
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
package com.arikko.scene_switch;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;

public class LayoutViewController {
    @javafx.fxml.FXML
    private BorderPane layoutBorderPane;

    private int dummyUser = 99;
    private String dummyUserType = "admin";

    @javafx.fxml.FXML
    private Menu adminMenu;
    @javafx.fxml.FXML
    private Menu customerSupportMenu;

    @javafx.fxml.FXML
    public void initialize() {
        if (dummyUserType.equals("admin")) {
            adminMenu.setVisible(true);
            customerSupportMenu.setVisible(false);
        } else if (dummyUserType.equals("customer-support")) {
            adminMenu.setVisible(false);
            customerSupportMenu.setVisible(true);
        }
    }

    @javafx.fxml.FXML
    public void showCustomerSupportViewOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("CustomerSupportView.fxml"));
            layoutBorderPane.setCenter(fxmlLoader.load());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void showAdminViewOnAction(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("AdminView.fxml"));
            layoutBorderPane.setCenter(fxmlLoader.load());
            AdminViewController adminViewController = (AdminViewController) fxmlLoader.getController();
            adminViewController.setDummyUser(this.dummyUser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
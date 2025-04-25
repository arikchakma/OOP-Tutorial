package com.arikko.scene_switch;

import javafx.scene.control.Label;

public class AdminViewController {
    private int dummyUser;

    @javafx.fxml.FXML
    private Label dummyUserLabel;

    public void setDummyUser(int dummyUser) {
        this.dummyUser = dummyUser;
        dummyUserLabel.setText(Integer.toString(dummyUser));
    }

    @javafx.fxml.FXML
    public void initialize() {
    }
}
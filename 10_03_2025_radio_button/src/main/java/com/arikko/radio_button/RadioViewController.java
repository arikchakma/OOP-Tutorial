package com.arikko.radio_button;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import javax.sound.midi.SysexMessage;
import java.util.ArrayList;

public class RadioViewController
{
    @javafx.fxml.FXML
    private RadioButton otherRadioButton;
    @javafx.fxml.FXML
    private RadioButton femaleRadioButton;
    @javafx.fxml.FXML
    private RadioButton maleRadioButton;

    ToggleGroup tg;

    @javafx.fxml.FXML
    public void initialize() {
        tg = new ToggleGroup();
        maleRadioButton.setToggleGroup(tg);
        femaleRadioButton.setToggleGroup(tg);
        otherRadioButton.setToggleGroup(tg);
    }

    @javafx.fxml.FXML
    public void showToggleValueOnAction(ActionEvent actionEvent) {
        String gender = ((RadioButton) tg.getSelectedToggle()).getText();
        System.out.println(gender);

        ArrayList<String> sidebars = new ArrayList<>();
        // if(recentsCheckBox.getIsChecked()) {sidebars.add("recents")}
        // if(homeCheckBox.getIsChecked()) {sidebars.add("home")}
    }
}
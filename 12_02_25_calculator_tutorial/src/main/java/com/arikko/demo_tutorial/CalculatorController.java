package com.arikko.demo_tutorial;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CalculatorController {

    @FXML
    private Button divideButton;
    @FXML
    private TextField firstNumberTextField;
    @FXML
    private Button multiplyButton;
    @FXML
    private CheckBox addTwoCheckBox;
    @FXML
    private TextField secondNumberTextField;
    @FXML
    private Label valueLabel;

    @FXML
    public void divideOnAction(ActionEvent actionEvent) {
        float firstNumber = Integer.parseInt(firstNumberTextField.getText());
        float secondNumber = Integer.parseInt(secondNumberTextField.getText());

        if(addTwoCheckBox.isSelected()){
            firstNumber = firstNumber + 2;
        }

        float result = firstNumber / secondNumber; // 3/2 => 1.5 float => 1
        valueLabel.setText(Float.toString(result));
        firstNumberTextField.clear();
        secondNumberTextField.clear();
    }

    @FXML
    public void multiplyOnAction(ActionEvent actionEvent) {
        int firstNumber = Integer.parseInt(firstNumberTextField.getText());
        int secondNumber = Integer.parseInt(secondNumberTextField.getText());

        if(addTwoCheckBox.isSelected()){
            firstNumber = firstNumber + 2;
        }

        int result = firstNumber * secondNumber;
        valueLabel.setText(Integer.toString(result));
        firstNumberTextField.clear();
        secondNumberTextField.clear();
    }
}
package com.arikko.prev_final_exam_solution;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Scene1DataGenerationController {
    @javafx.fxml.FXML
    private ComboBox<String> diagonalComboBox;
    @javafx.fxml.FXML
    private TableColumn<Monitor, String> resolutionTableCol;
    @javafx.fxml.FXML
    private TableColumn<Monitor, String> modelTableCol;
    @javafx.fxml.FXML
    private TableView<Monitor> monitorsTableView;
    @javafx.fxml.FXML
    private TableColumn<Monitor, String> diagonalTableCol;
    @javafx.fxml.FXML
    private ComboBox<String> resolutionComboBox;
    @javafx.fxml.FXML
    private TableColumn<Monitor, Float> priceTableCol;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private TextField modelTextField;
    @javafx.fxml.FXML
    private Text errorMessageText;

    public void initialize() {
        resolutionComboBox.getItems().addAll("HD", "HD+", "Full-HD", "QHD");
        diagonalComboBox.getItems().addAll("17 Inches", "19 Inches", "22 Inches", "24 Inches");

        modelTableCol.setCellValueFactory(new PropertyValueFactory<Monitor, String>("model"));
        resolutionTableCol.setCellValueFactory(new PropertyValueFactory<Monitor, String>("resolution"));
        diagonalTableCol.setCellValueFactory(new PropertyValueFactory<Monitor, String>("diagonal"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<Monitor, Float>("price"));
    }

    @javafx.fxml.FXML
    public void goToScene2OnAction(ActionEvent actionEvent) {
        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene2-data-processing.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void saveToBinFileOnAction(ActionEvent actionEvent) {
        for (Monitor m : monitorsTableView.getItems()) {
            try {
                File file = new File("monitors.bin");
                FileOutputStream fos = null;
                ObjectOutputStream oos = null;

                if (!file.exists()) {
                    fos = new FileOutputStream(file);
                    oos = new ObjectOutputStream(fos);
                    // ---------------------------
                    // Model | Resolution | Diagonal
                    // ---------------------------
                } else {
                    fos = new FileOutputStream(file, true);
                    oos = new AppendableObjectOutputStream(fos);
                }

                // Bug
                // file doesn't exist -> header append
                // 1. header append -> rest
                // 2. header append -> rest

                // Solved One
                // 1 -> file doesn't exist -> header append
                // 2 -> file exist -> header won't append
                // 3 ->
                oos.writeObject(m);
                oos.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }


    @javafx.fxml.FXML
    public void addMonitorOnAction(ActionEvent actionEvent) {
        String model = modelTextField.getText();
        String resolution = resolutionComboBox.getValue();
        String diagonal = diagonalComboBox.getValue();
        String priceStr = priceTextField.getText();

        if (model.isEmpty() || resolution.isEmpty() || diagonal.isEmpty() || priceStr.isEmpty()) {
            errorMessageText.setText("Please provide all values");
            return;
        }

        float price = Float.parseFloat(priceStr);

        Monitor monitor = new Monitor(model, resolution, diagonal, price);
        monitorsTableView.getItems().add(monitor);

        modelTextField.clear();
        priceTextField.clear();
    }
}

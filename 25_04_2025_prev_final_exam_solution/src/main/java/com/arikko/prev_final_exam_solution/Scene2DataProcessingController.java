package com.arikko.prev_final_exam_solution;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class Scene2DataProcessingController {
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, String> resolutionTableCol;
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, String> modelTableCol;
    @javafx.fxml.FXML
    private TableView<DummyMonitor> monitorsTableView;
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, String> diagonalTableCol;
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, Float> priceTableCol;
    @javafx.fxml.FXML
    private TableColumn<DummyMonitor, Integer> ppiTableCol;
    @javafx.fxml.FXML
    private Text errorMessageText;

    public void initialize() {
        modelTableCol.setCellValueFactory(new PropertyValueFactory<DummyMonitor, String>("model"));
        resolutionTableCol.setCellValueFactory(new PropertyValueFactory<DummyMonitor, String>("resolution"));
        diagonalTableCol.setCellValueFactory(new PropertyValueFactory<DummyMonitor, String>("diagonal"));
        priceTableCol.setCellValueFactory(new PropertyValueFactory<DummyMonitor, Float>("price"));
        ppiTableCol.setCellValueFactory(new PropertyValueFactory<DummyMonitor, Integer>("ppi"));
    }

    @javafx.fxml.FXML
    public void backToScene1OnAction(ActionEvent actionEvent) {
        try {
            Scene scene = ((Button) actionEvent.getSource()).getScene();
            Stage stage = (Stage) scene.getWindow();

            FXMLLoader scene2FxmlLoader = new FXMLLoader(HelloApplication.class.getResource("scene1-data-generation.fxml"));
            Scene scene2 = new Scene(scene2FxmlLoader.load());
            stage.setScene(scene2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @javafx.fxml.FXML
    public void loadDataFromBinOnAction(ActionEvent actionEvent) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            File file = new File("monitors.bin");
            if (!file.exists()) {
                errorMessageText.setText("Please add monitors.");
                return;
            }

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);


            while (true) {
                try {
                    Monitor m = (Monitor) ois.readObject();
                    DummyMonitor dm = new DummyMonitor(m.getModel(), m.getResolution(), m.getDiagonal(), m.getPrice(), m.getPPI());
                    monitorsTableView.getItems().add(dm);
                } catch (EOFException e) {
                    break;
                }
            }

            ois.close();
        } catch (Exception e) {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            throw new RuntimeException(e);
        }
    }
}

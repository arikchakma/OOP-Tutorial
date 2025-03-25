package com.arikko.acme_store.controllers;

import com.arikko.acme_store.product.Cup;
import com.arikko.acme_store.product.Hoodie;
import com.arikko.acme_store.product.Product;
import com.arikko.acme_store.product.TShirt;
import com.arikko.acme_store.users.User;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CreateProductViewController {
    @javafx.fxml.FXML
    private Label materialLabel;
    @javafx.fxml.FXML
    private RadioButton drinkwareRadioButton;
    @javafx.fxml.FXML
    private TextField nameTextField;
    @javafx.fxml.FXML
    private TextField sizeTextField;
    @javafx.fxml.FXML
    private TextArea descriptionTextArea;
    @javafx.fxml.FXML
    private RadioButton cupRadioButton;
    @javafx.fxml.FXML
    private RadioButton apparelRadioButton;
    @javafx.fxml.FXML
    private Label colorsLabel;
    @javafx.fxml.FXML
    private Label sizesLabel;
    @javafx.fxml.FXML
    private Label apparelProductDetailsLabel;
    @javafx.fxml.FXML
    private TextField colorTextField;
    @javafx.fxml.FXML
    private RadioButton tshirtRadioButton;
    @javafx.fxml.FXML
    private RadioButton hoodieRadioButton;
    @javafx.fxml.FXML
    private TextField materialTextField;
    @javafx.fxml.FXML
    private Button addSizeButton;
    @javafx.fxml.FXML
    private Label drinkwareProductDetailsLabel;
    @javafx.fxml.FXML
    private TextField priceTextField;
    @javafx.fxml.FXML
    private Label addSizeLabel;
    @javafx.fxml.FXML
    private TextField quantityTextField;

    // dummy local database
    private ArrayList<User> users;
    private User currentUser = null;
    private ArrayList<Product> products;

    public void setDummyDb(ArrayList<User> users, ArrayList<Product> products) {
        this.users = users;
        this.products = products;
    }

    ToggleGroup productTypeTg;
    ToggleGroup apparelTypeTg;
    ToggleGroup drinkwareTypeTg;

    ArrayList<String> productColors;
    ArrayList<String> apparelProductSizes;

    @javafx.fxml.FXML
    public void initialize() {
        productTypeTg = new ToggleGroup();
        apparelRadioButton.setToggleGroup(productTypeTg);
        drinkwareRadioButton.setToggleGroup(productTypeTg);

        apparelTypeTg = new ToggleGroup();
        tshirtRadioButton.setToggleGroup(apparelTypeTg);
        hoodieRadioButton.setToggleGroup(apparelTypeTg);

        drinkwareTypeTg = new ToggleGroup();
        cupRadioButton.setToggleGroup(drinkwareTypeTg);

        productColors = new ArrayList<>();
        apparelProductSizes = new ArrayList<>();

        // Apparel Product Details
        apparelProductDetailsLabel.setVisible(false);
        tshirtRadioButton.setVisible(false);
        hoodieRadioButton.setVisible(false);
        materialLabel.setVisible(false);
        materialTextField.setVisible(false);
        addSizeLabel.setVisible(false);
        sizeTextField.setVisible(false);
        addSizeButton.setVisible(false);
        sizesLabel.setVisible(false);

        // Drinkware Product Details
        drinkwareProductDetailsLabel.setVisible(false);
        cupRadioButton.setVisible(false);
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

    @javafx.fxml.FXML
    public void addNewProductOnAction(ActionEvent actionEvent) {
        String name = nameTextField.getText();
        String description = descriptionTextArea.getText();
        String productType = ((RadioButton) productTypeTg.getSelectedToggle()).getText().toLowerCase();
        int quantity = Integer.parseInt(quantityTextField.getText());
        float price = Float.parseFloat(priceTextField.getText());
        int newId = Product.generateProductId(this.products);

        Product newProduct = null;
        if (productType.equals("drinkware")) {
            String type = ((RadioButton) drinkwareTypeTg.getSelectedToggle()).getText().toLowerCase();
            newProduct = new Cup(newId, name, description, type, productColors, quantity, price);
        } else {
            String type = ((RadioButton) apparelTypeTg.getSelectedToggle()).getText().toLowerCase();
            String material = materialTextField.getText();
            if (type.equals("t-shirt")) {
                newProduct = new TShirt(newId, name, description, type, productColors, quantity, price, apparelProductSizes, material);
            } else if (type.equals("hoodie")) {
                newProduct = new Hoodie(newId, name, description, type, productColors, quantity, price, apparelProductSizes, material);
            }
        }

        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (newProduct == null) {
            alert.setHeaderText("Please select a valid product type");
            alert.showAndWait();
            return;
        }

        this.products.add(newProduct);
        nameTextField.clear();
        descriptionTextArea.clear();
        quantityTextField.clear();
        priceTextField.clear();
        materialTextField.clear();
        productColors = new ArrayList<>();
        apparelProductSizes = new ArrayList<>();

        alert.setAlertType(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Successfully created a new Product");
        alert.show();
    }

    @javafx.fxml.FXML
    public void addColorOnAction(ActionEvent actionEvent) {
        String color = colorTextField.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (color.isEmpty()) {
            alert.setHeaderText("Please use a valid color");
            alert.showAndWait();
            return;
        }

        if (productColors.contains(color)) {
            alert.setHeaderText("Color already exist");
            alert.showAndWait();
            return;
        }

        productColors.add(color);
        String colors = "Colors: ";
        for (String c : productColors) {
            colors += c + ", ";
        }

        colorTextField.clear();
        colorsLabel.setText(colors);
    }

    @javafx.fxml.FXML
    public void addSizeOnAction(ActionEvent actionEvent) {
        String size = sizeTextField.getText();
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (size.isEmpty()) {
            alert.setHeaderText("Please use a valid size");
            alert.showAndWait();
            return;
        }

        if (apparelProductSizes.contains(size)) {
            alert.setHeaderText("Size already exist");
            alert.showAndWait();
            return;
        }

        apparelProductSizes.add(size);
        String sizes = "Sizes: ";
        for (String s : apparelProductSizes) {
            sizes += s + ", ";
        }

        sizeTextField.clear();
        sizesLabel.setText(sizes);
    }

    @javafx.fxml.FXML
    public void apparelRadioButtonOnAction(ActionEvent actionEvent) {
        // Apparel Product Details
        apparelProductDetailsLabel.setVisible(true);
        tshirtRadioButton.setVisible(true);
        hoodieRadioButton.setVisible(true);
        materialLabel.setVisible(true);
        materialTextField.setVisible(true);
        addSizeLabel.setVisible(true);
        sizeTextField.setVisible(true);
        addSizeButton.setVisible(true);
        sizesLabel.setVisible(true);

        // Drinkware Product Details
        drinkwareProductDetailsLabel.setVisible(false);
        cupRadioButton.setVisible(false);
    }

    @javafx.fxml.FXML
    public void drinkwareRadioButtonOnAction(ActionEvent actionEvent) {
        // Apparel Product Details
        apparelProductDetailsLabel.setVisible(false);
        tshirtRadioButton.setVisible(false);
        hoodieRadioButton.setVisible(false);
        materialLabel.setVisible(false);
        materialTextField.setVisible(false);
        addSizeLabel.setVisible(false);
        sizeTextField.setVisible(false);
        addSizeButton.setVisible(false);
        sizesLabel.setVisible(false);

        // Drinkware Product Details
        drinkwareProductDetailsLabel.setVisible(true);
        cupRadioButton.setVisible(true);

        apparelProductSizes.clear();
    }
}
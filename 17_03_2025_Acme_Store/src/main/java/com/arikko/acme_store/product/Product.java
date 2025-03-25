package com.arikko.acme_store.product;

import java.util.ArrayList;

public abstract class Product {
    private int id;
    private String name, description, productType;
    private ArrayList<String> colors;
    private int quantity;
    private float price;

    public Product() {
    }

    public Product(int id, String name, String description, String productType, ArrayList<String> colors, int quantity, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.productType = productType;
        this.colors = colors;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + productType + '\'' +
                ", colors=" + colors +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

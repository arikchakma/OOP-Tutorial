package com.arikko.acme_store.product;

import java.util.ArrayList;

public abstract class ApparelProduct extends Product {
    private ArrayList<String> sizes;
    private String material;
    private String type; // hoodie/t-shirt

    public ApparelProduct() {
    }

    public ApparelProduct(int id, String name, String description, String productType, ArrayList<String> colors, int quantity, float price, ArrayList<String> sizes, String material, String type) {
        super(id, name, description, productType, colors, quantity, price);
        this.sizes = sizes;
        this.material = material;
        this.type = type;
    }

    public ArrayList<String> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<String> sizes) {
        this.sizes = sizes;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ApparelProduct{" +
                "sizes=" + sizes +
                ", material='" + material + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}

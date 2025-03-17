package com.arikko.acme_store.product;

import java.util.ArrayList;

public abstract class ApparelProduct extends Product {
    private ArrayList<String> sizes;
    private String material;

    public ApparelProduct() {
    }

    public ApparelProduct(int id, String name, String description, String type, ArrayList<String> colors, int quantity, float price, ArrayList<String> sizes, String material) {
        super(id, name, description, type, colors, quantity, price);
        this.sizes = sizes;
        this.material = material;
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

    @Override
    public String toString() {
        return "TextileProduct{" +
                "sizes=" + sizes +
                ", material='" + material + '\'' +
                '}';
    }
}

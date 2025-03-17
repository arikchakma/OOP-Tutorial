package com.arikko.acme_store.orders;

public abstract class CheckoutProduct {
    private String type;
    private int productId, quantity;
    private String color;

    public CheckoutProduct() {
    }

    public CheckoutProduct(String type, int productId, int quantity, String color) {
        this.type = type;
        this.productId = productId;
        this.quantity = quantity;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "CheckoutProduct{" +
                "type='" + type + '\'' +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", color='" + color + '\'' +
                '}';
    }
}

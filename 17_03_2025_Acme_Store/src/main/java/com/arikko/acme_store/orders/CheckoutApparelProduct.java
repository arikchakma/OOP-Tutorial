package com.arikko.acme_store.orders;

public class CheckoutApparelProduct extends CheckoutProduct {
    private String size;

    public CheckoutApparelProduct() {
    }

    public CheckoutApparelProduct(String type, int productId, int quantity, String size) {
        super(type, productId, quantity);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "CheckoutApparelProduct{" +
                "size='" + size + '\'' +
                '}';
    }
}

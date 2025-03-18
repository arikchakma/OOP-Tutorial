package com.arikko.acme_store.orders;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    private int id, userId;
    private ArrayList<CheckoutProduct> products;
    private ShippingDetails shippingDetails;
    private float total;
    private String status; // pending, dispatched, delivered, failed
    private LocalDate deliveredAt, dispatchedAt, failedAt;
    private String failedReason;

    public Order() {
    }

    public Order(int id, int userId, ArrayList<CheckoutProduct> products, ShippingDetails shippingDetails, float total, String status, LocalDate deliveredAt, LocalDate dispatchedAt, LocalDate failedAt, String failedReason) {
        this.id = id;
        this.userId = userId;
        this.products = products;
        this.shippingDetails = shippingDetails;
        this.total = total;
        this.status = status;
        this.deliveredAt = deliveredAt;
        this.dispatchedAt = dispatchedAt;
        this.failedAt = failedAt;
        this.failedReason = failedReason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<CheckoutProduct> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<CheckoutProduct> products) {
        this.products = products;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(LocalDate deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public LocalDate getDispatchedAt() {
        return dispatchedAt;
    }

    public void setDispatchedAt(LocalDate dispatchedAt) {
        this.dispatchedAt = dispatchedAt;
    }

    public LocalDate getFailedAt() {
        return failedAt;
    }

    public void setFailedAt(LocalDate failedAt) {
        this.failedAt = failedAt;
    }

    public String getFailedReason() {
        return failedReason;
    }

    public void setFailedReason(String failedReason) {
        this.failedReason = failedReason;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", products=" + products +
                ", shippingDetails=" + shippingDetails +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", deliveredAt=" + deliveredAt +
                ", dispatchedAt=" + dispatchedAt +
                ", failedAt=" + failedAt +
                ", failedReason='" + failedReason + '\'' +
                '}';
    }
}

package com.example.erp.model;

public class Sale {

    private int saleId;
    private String productName;
    private int quantity;
    private double totalAmount;

    public Sale() {
    }

    public Sale(int saleId, String productName,
                int quantity, double totalAmount) {
        this.saleId = saleId;
        this.productName = productName;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
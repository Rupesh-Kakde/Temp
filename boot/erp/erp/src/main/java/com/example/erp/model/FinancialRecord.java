package com.example.erp.model;

public class FinancialRecord {

    private int id;
    private String type;
    private double amount;
    private String description;

    public FinancialRecord() {
    }

    public FinancialRecord(int id, String type,
                           double amount,
                           String description) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
package com.example.erp.service;

import com.example.erp.model.FinancialRecord;
import com.example.erp.model.InventoryItem;
import com.example.erp.model.Sale;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ErpService {

    private final List<InventoryItem> inventory = new ArrayList<>();
    private final List<Sale> sales = new ArrayList<>();
    private final List<FinancialRecord> financialRecords = new ArrayList<>();

    public ErpService() {

        inventory.add(
            new InventoryItem(1, "Laptop", 10, 50000)
        );

        inventory.add(
            new InventoryItem(2, "Keyboard", 25, 1200)
        );

        sales.add(
            new Sale(1, "Laptop", 2, 100000)
        );

        financialRecords.add(
            new FinancialRecord(
                1,
                "Income",
                100000,
                "Laptop sales"
            )
        );
    }

    // ---------------- INVENTORY ----------------

    public List<InventoryItem> getAllInventory() {
        return inventory;
    }

    public InventoryItem addInventory(InventoryItem item) {
        inventory.add(item);
        return item;
    }

    // ---------------- SALES ----------------

    public List<Sale> getAllSales() {
        return sales;
    }

    public Sale addSale(Sale sale) {
        sales.add(sale);

        FinancialRecord record =
                new FinancialRecord(
                        financialRecords.size() + 1,
                        "Income",
                        sale.getTotalAmount(),
                        "Sale of " + sale.getProductName()
                );

        financialRecords.add(record);

        return sale;
    }

    // ---------------- FINANCE ----------------

    public List<FinancialRecord> getAllFinancialRecords() {
        return financialRecords;
    }

    public FinancialRecord addFinancialRecord(
            FinancialRecord record) {

        financialRecords.add(record);

        return record;
    }
}
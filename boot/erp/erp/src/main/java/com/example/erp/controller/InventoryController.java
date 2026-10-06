package com.example.erp.controller;

import com.example.erp.model.InventoryItem;
import com.example.erp.service.ErpService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final ErpService erpService;

    public InventoryController(ErpService erpService) {
        this.erpService = erpService;
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getInventory() {

        return ResponseEntity.ok(
                erpService.getAllInventory()
        );
    }

    @PostMapping
    public ResponseEntity<InventoryItem> addInventory(
            @RequestBody InventoryItem item) {

        return ResponseEntity.ok(
                erpService.addInventory(item)
        );
    }
}
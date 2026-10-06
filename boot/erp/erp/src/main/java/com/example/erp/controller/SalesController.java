package com.example.erp.controller;

import com.example.erp.model.Sale;
import com.example.erp.service.ErpService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SalesController {

    private final ErpService erpService;

    public SalesController(ErpService erpService) {
        this.erpService = erpService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getSales() {

        return ResponseEntity.ok(
                erpService.getAllSales()
        );
    }

    @PostMapping
    public ResponseEntity<Sale> addSale(
            @RequestBody Sale sale) {

        return ResponseEntity.ok(
                erpService.addSale(sale)
        );
    }
}
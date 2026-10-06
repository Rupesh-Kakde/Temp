package com.example.erp.controller;

import com.example.erp.model.FinancialRecord;
import com.example.erp.service.ErpService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {

    private final ErpService erpService;

    public FinanceController(ErpService erpService) {
        this.erpService = erpService;
    }

    @GetMapping
    public ResponseEntity<List<FinancialRecord>> getFinance() {

        return ResponseEntity.ok(
                erpService.getAllFinancialRecords()
        );
    }

    @PostMapping
    public ResponseEntity<FinancialRecord> addFinance(
            @RequestBody FinancialRecord record) {

        return ResponseEntity.ok(
                erpService.addFinancialRecord(record)
        );
    }
}
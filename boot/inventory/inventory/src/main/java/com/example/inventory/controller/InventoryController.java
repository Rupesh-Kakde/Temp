package com.example.inventory.controller;

import com.example.inventory.model.Product;
import com.example.inventory.service.InventoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(
            InventoryService inventoryService) {

        this.inventoryService = inventoryService;
    }

    // 1. Get all products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(
                inventoryService.getAllProducts()
        );
    }

    // 2. Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(
            @PathVariable int id) {

        Product product =
                inventoryService.getProductById(id);

        if (product != null) {
            return ResponseEntity.ok(product);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Product not found");
    }

    // 3. Add product
    @PostMapping
    public ResponseEntity<Product> addProduct(
            @RequestBody Product product) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                    inventoryService.addProduct(product)
                );
    }

    // 4. Update product
    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {

        Product updatedProduct =
                inventoryService.updateProduct(
                        id,
                        product
                );

        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Product not found");
    }

    // 5. Delete product
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable int id) {

        boolean deleted =
                inventoryService.deleteProduct(id);

        if (deleted) {

            return ResponseEntity.ok(
                    "Product deleted successfully"
            );
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Product not found");
    }
}
package com.example.inventory.service;

import com.example.inventory.model.Product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {

    private final List<Product> products = new ArrayList<>();

    public InventoryService() {

        products.add(
                new Product(
                        1,
                        "Laptop",
                        "Electronics",
                        10,
                        50000
                )
        );

        products.add(
                new Product(
                        2,
                        "Mouse",
                        "Accessories",
                        25,
                        700
                )
        );
    }

    // Get all products
    public List<Product> getAllProducts() {
        return products;
    }

    // Get product by ID
    public Product getProductById(int id) {

        for (Product product : products) {

            if (product.getId() == id) {
                return product;
            }
        }

        return null;
    }

    // Add product
    public Product addProduct(Product product) {

        products.add(product);

        return product;
    }

    // Update product
    public Product updateProduct(int id, Product updatedProduct) {

        Product existingProduct =
                getProductById(id);

        if (existingProduct != null) {

            existingProduct.setName(
                    updatedProduct.getName()
            );

            existingProduct.setCategory(
                    updatedProduct.getCategory()
            );

            existingProduct.setQuantity(
                    updatedProduct.getQuantity()
            );

            existingProduct.setPrice(
                    updatedProduct.getPrice()
            );

            return existingProduct;
        }

        return null;
    }

    // Delete product
    public boolean deleteProduct(int id) {

        return products.removeIf(
                product -> product.getId() == id
        );
    }
}
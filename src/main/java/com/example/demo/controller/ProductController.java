package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StoreRepository storeRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/stores/{storeId}/products")
    public List<Product> getAllProductsByStoreId(@PathVariable Long storeId) {
        if (!storeRepository.existsById(storeId)) {
            throw new NotFoundException("Store not found with id " + storeId);
        }
        return productRepository.findByStoreId(storeId);
    }

    @PostMapping("/stores/{storeId}/products")
    public Product addProduct(@PathVariable Long storeId, @Valid @RequestBody Product product) {
        return storeRepository.findById(storeId).map(store -> {
            product.setStore(store);
            return productRepository.save(product);
        }).orElseThrow(() -> new NotFoundException("Store not found with id " + storeId));
    }

    @DeleteMapping("/stores/{storeId}/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long storeId, @PathVariable Long productId) {
        if (!storeRepository.existsById(storeId)) {
            throw new NotFoundException("Store not found with id " + storeId);
        }

        return productRepository.findById(productId).map(product -> {
            productRepository.delete(product);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new NotFoundException("Product not found with id " + productId));

    }
}
package com.ws101.escala.controller;

import com.ws101.escala.dto.ProductRequest; // Import the DTO from Task 4
import com.ws101.escala.model.Product;
import com.ws101.escala.service.ProductService;
import jakarta.validation.Valid; // Task 4.2: Import for validation
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize; // Task 3.1: For RBAC
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Lab 8: Returns all products in the catalog.
     * Public access (Defined in SecurityConfig)
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Task 4.2: Creates a new product with Bean Validation.
     * Accessible to Authenticated Users (or ADMIN depends on your preference)
     */
    @PostMapping
    @PreAuthorize("isAuthenticated()") // Task 3.1
    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductRequest dto) {
        // Map DTO to Entity
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setImageUrl(dto.imageUrl());
        
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Task 3.1: Only Admin can update
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest dto) {
        Product product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setImageUrl(dto.imageUrl());
        
        Product updated = productService.updateProduct(id, product);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Task 3.1: Secured with Role-Based Access Control (RBAC).
     * Only users with ROLE_ADMIN can delete products.
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')") // Task 3.1
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id) 
            ? new ResponseEntity<>(HttpStatus.NO_CONTENT) 
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

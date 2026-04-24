package com.ws101.escala.controller;

import com.ws101.escala.model.Product;
import com.ws101.escala.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing pet products.
 * [span_21](start_span)Exposes API endpoints under the /api/v1/products base path.[span_21](end_span)
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * [span_22](start_span)Returns all products in the catalog.[span_22](end_span)
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK); [span_23](start_span)// 200 OK[span_23](end_span)
    }

    /**
     * [span_24](start_span)Returns a specific product by ID.[span_24](end_span)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); [span_25](start_span)// 404 Not Found[span_25](end_span)
    }

    /**
     * [span_26](start_span)Filters products by type and value via RequestParam.[span_26](end_span)
     */
    @GetMapping("/filter")
    public ResponseEntity<List<Product>> filterProducts(
            @RequestParam String filterType, 
            @RequestParam String filterValue) {
        return new ResponseEntity<>(productService.filterProducts(filterType, filterValue), HttpStatus.OK);
    }

    /**
     * [span_27](start_span)Creates a new product.[span_27](end_span)
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED); [span_28](start_span)// 201 Created[span_28](end_span)
    }

    /**
     * [span_29](start_span)Replaces an existing product.[span_29](end_span)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updated = productService.updateProduct(id, product);
        return updated != null ? new ResponseEntity<>(updated, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * [span_30](start_span)Deletes a product by ID.[span_30](end_span)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id) 
            [span_31](start_span)? new ResponseEntity<>(HttpStatus.NO_CONTENT) // 204 No Content[span_31](end_span)
            : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

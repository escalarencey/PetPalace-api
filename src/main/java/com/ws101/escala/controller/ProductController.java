package com.ws101.escala.controller;

import com.ws101.escala.model.Product;
import com.ws101.escala.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() { return productService.getAllProducts(); }

    @PostMapping
    public Product create(@RequestBody Product product) { return productService.createProduct(product); }
}

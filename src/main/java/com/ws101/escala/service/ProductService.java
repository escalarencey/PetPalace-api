package com.ws101.escala.service;

import com.ws101.escala.model.Product;
import com.ws101.escala.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id).map(p -> {
            p.setName(updatedProduct.getName());
            p.setDescription(updatedProduct.getDescription());
            p.setPrice(updatedProduct.getPrice());
            p.setStockQuantity(updatedProduct.getStockQuantity());
            return productRepository.save(p);
        }).orElse(null);
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Product> filterProducts(String type, String value) {
        if ("category".equalsIgnoreCase(type)) {
            return productRepository.findByCategoryNameIgnoreCase(value);
        }
        if ("price".equalsIgnoreCase(type)) {
            return productRepository.findByPriceRange(0.0, Double.parseDouble(value));
        }
        return productRepository.findAll();
    }
}

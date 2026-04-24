package com.ws101.escala.service;

import com.ws101.escala.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();
    private long idCounter = 1;

    public ProductService() {
        productList.add(new Product(idCounter++, "Blue Dog Harness", "Durable blue harness", 280.0, "Dogs", 15, "harness.jpg"));
        productList.add(new Product(idCounter++, "Amber Dog Harness", "Stylish amber harness", 350.0, "Dogs", 10, "amber.jpg"));
        productList.add(new Product(idCounter++, "Pedigree Adult Beef", "Nutritious beef flavor", 130.0, "Dogs", 50, "pedigree.jpg"));
        productList.add(new Product(idCounter++, "Cat Laser Toy", "Interactive laser toy", 40.0, "Cats", 25, "laser.jpg"));
        productList.add(new Product(idCounter++, "KitKat Premium Food", "Premium cat nutrition", 220.0, "Cats", 30, "kitkat.jpg"));
        productList.add(new Product(idCounter++, "Multi-Level Tower", "Luxury cat climber", 1250.0, "Cats", 5, "tower.jpg"));
        productList.add(new Product(idCounter++, "Natural Wood Perch", "Eco-friendly bird perch", 227.0, "Birds", 12, "perch.jpg"));
        productList.add(new Product(idCounter++, "Elixir Bird Feeds", "Daily bird nutrition", 35.0, "Birds", 100, "elixir.jpg"));
        productList.add(new Product(idCounter++, "Premium Bird Mix", "High-energy mix", 37.0, "Birds", 80, "premium.jpg"));
        productList.add(new Product(idCounter++, "Fish Pellets", "Daily fish food", 69.0, "Fish", 200, "pellets.jpg"));
    }

    public List<Product> getAllProducts() { return productList; }

    public Optional<Product> getProductById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public Product createProduct(Product product) {
        product.setId(idCounter++);
        productList.add(product);
        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        return getProductById(id).map(p -> {
            p.setName(updatedProduct.getName());
            p.setDescription(updatedProduct.getDescription());
            p.setPrice(updatedProduct.getPrice());
            p.setCategory(updatedProduct.getCategory());
            p.setStockQuantity(updatedProduct.getStockQuantity());
            return p;
        }).orElse(null);
    }

    public boolean deleteProduct(Long id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }
}


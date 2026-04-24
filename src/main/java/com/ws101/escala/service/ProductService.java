package com.ws101.escala.service;

import com.ws101.escala.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class for product-related operations.
 * Manages an in-memory list of pet products and provides business logic for CRUD operations.
 * * @author Rence A. Escala
 */
@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();
    private long idCounter = 1;

    public ProductService() {
        [span_9](start_span)// Task 3.1: Initialize with 13 products[span_9](end_span)
        productList.add(new Product(idCounter++, "Blue Dog Harness", "Durable blue harness", 280.0, "Dogs", 15, "harness.jpg"));
        productList.add(new Product(idCounter++, "Amber Dog Harness", "Stylish amber harness", 350.0, "Dogs", 10, "amber.jpg"));
        productList.add(new Product(idCounter++, "Pedigree Adult Beef", "Nutritious beef flavor", 130.0, "Dogs", 50, "pedigree.jpg"));
        productList.add(new Product(idCounter++, "Heavy Duty Leash", "5ft reinforced nylon leash", 150.0, "Dogs", 20, "leash.jpg"));
        productList.add(new Product(idCounter++, "Cat Laser Toy", "Interactive laser toy", 40.0, "Cats", 25, "laser.jpg"));
        productList.add(new Product(idCounter++, "KitKat Premium Food", "Premium cat nutrition", 220.0, "Cats", 30, "kitkat.jpg"));
        productList.add(new Product(idCounter++, "Multi-Level Tower", "Luxury cat climber", 1250.0, "Cats", 5, "tower.jpg"));
        productList.add(new Product(idCounter++, "Catnip Infused Ball", "Fun toy for active cats", 25.0, "Cats", 40, "catnip.jpg"));
        productList.add(new Product(idCounter++, "Natural Wood Perch", "Eco-friendly bird perch", 227.0, "Birds", 12, "perch.jpg"));
        productList.add(new Product(idCounter++, "Elixir Bird Feeds", "Daily bird nutrition", 35.0, "Birds", 100, "elixir.jpg"));
        productList.add(new Product(idCounter++, "Premium Bird Mix", "High-energy mix", 37.0, "Birds", 80, "premium.jpg"));
        productList.add(new Product(idCounter++, "Fish Pellets", "Daily fish food", 69.0, "Fish", 200, "pellets.jpg"));
        productList.add(new Product(idCounter++, "LED Aquarium Light", "Energy efficient tank light", 450.0, "Fish", 8, "led.jpg"));
    }

    /**
     * [span_10](start_span)Retrieves all products from the in-memory store.[span_10](end_span)
     * @return a List of all Product objects.
     */
    public List<Product> getAllProducts() { return productList; }

    /**
     * [span_11](start_span)Finds a single product by its unique ID.[span_11](end_span)
     * @param id The unique identifier of the product.
     * @return An Optional containing the product if found.
     */
    public Optional<Product> getProductById(Long id) {
        return productList.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    /**
     * [span_12](start_span)Creates and adds a new product to the list.[span_12](end_span)
     * @param product The product object to be added.
     * [span_13](start_span)@return The newly created product with its generated ID.[span_13](end_span)
     */
    public Product createProduct(Product product) {
        product.setId(idCounter++);
        productList.add(product);
        return product;
    }

    /**
     * [span_14](start_span)Updates an existing product's information.[span_14](end_span)
     * @param id The ID of the product to update.
     * @param updatedProduct The new product data.
     * @return The updated product or null if it does not exist.
     */
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

    /**
     * [span_15](start_span)Removes a product from the list by its ID.[span_15](end_span)
     * @param id The unique ID of the product.
     * @return true if the product was removed, false otherwise.
     */
    public boolean deleteProduct(Long id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }

    /**
     * [span_16](start_span)Filters products based on specific criteria.[span_16](end_span)
     * [span_17](start_span)@param type The field to filter by (category, name, or price).[span_17](end_span)
     * @param value The value to match against the specified type.
     * @return A List of products matching the criteria.
     */
    public List<Product> filterProducts(String type, String value) {
        return productList.stream().filter(p -> {
            if ("category".equalsIgnoreCase(type)) return p.getCategory().equalsIgnoreCase(value);
            if ("name".equalsIgnoreCase(type)) return p.getName().toLowerCase().contains(value.toLowerCase());
            if ("price".equalsIgnoreCase(type)) return p.getPrice() <= Double.parseDouble(value);
            return true;
        }).collect(Collectors.toList());
    }
}

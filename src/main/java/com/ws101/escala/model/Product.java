package com.ws101.escala.model;

import lombok.*;

/**
 * Data entity representing a pet product for the EcommerceApi.
 */
@Getter 
@Setter 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString 
@EqualsAndHashCode
public class Product {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String category;
    private Integer stockQuantity;
    private String imageUrl;
}

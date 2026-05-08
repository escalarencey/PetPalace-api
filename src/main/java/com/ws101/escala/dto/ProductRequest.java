package com.ws101.escala.dto;

import jakarta.validation.constraints.*;

public record ProductRequest( // Task 4.2: DTO
    @NotBlank(message = "Name cannot be empty")
    @Size(min = 3, max = 50)
    String name,

    @Positive(message = "Price must be greater than zero")
    Double price,

    @NotBlank(message = "Image URL is required")
    String imageUrl
) {}


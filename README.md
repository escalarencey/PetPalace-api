# Pet Palace E-Commerce API

## Overview
This is a REST API built using Spring Boot for managing pet products.

## Endpoints

### GET all products
GET /api/v1/products

### GET product by ID
GET /api/v1/products/{id}

### CREATE product
POST /api/v1/products

### UPDATE product
PUT /api/v1/products/{id}

### PATCH product
PATCH /api/v1/products/{id}

### DELETE product
DELETE /api/v1/products/{id}

### FILTER products
GET /api/v1/products/filter?filterType=category&filterValue=Dogs

## Notes
- Uses in-memory storage (ArrayList)
- No database used

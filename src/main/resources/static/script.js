// script.js - Lab 8 Version (Full Stack)
const API_URL = "http://localhost:8080/api/v1/products";

// Task 5: Fetch data from MySQL Database
async function fetchProducts() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Database connection failed");
        
        const products = await response.json();
        renderProductList(products); // Ipapakita ang products sa catalog page
        updateFeaturedProduct(products); // Para sa landing page
    } catch (error) {
        console.error("Error:", error);
    }
}

// Function para ipakita ang products sa products.html
function renderProductList(products) {
    const productContainer = document.querySelector('.product-list');
    if (!productContainer) return;

    productContainer.innerHTML = products.map(p => `
        <article class="product-card">
            <img src="${p.imageUrl}" alt="${p.name}">
            <h3>${p.name}</h3>
            <p class="price">₱${p.price.toFixed(2)}</p>
            <div class="card-buttons">
                <a href="detail.html?id=${p.id}" class="btn">View Details</a>
                <button class="add-to-cart-btn btn" onclick="addToCart(${p.id})">Add to Cart</button>
            </div>
        </article>
    `).join('');
}

// Function para sa Featured Product sa landing.html
function updateFeaturedProduct(products) {
    const featuredSection = document.getElementById('featured');
    if (!featuredSection || products.length === 0) return;
    // Kukuha lang ng isa para sa feature
    const p = products[0]; 
    // ... logic for featured display ...
}

// Initialize
document.addEventListener('DOMContentLoaded', fetchProducts);

// Global user greeting
const greeting = document.getElementById('user-greeting');
if (greeting) greeting.textContent = "Rence A. Escala";

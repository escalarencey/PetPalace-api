/* =====================================================
   PET PALACE - LABORATORY 8 (FULL-STACK)
   Members: Rence A. Escala & Lyza Atencio
   ===================================================== */

const API_URL = "http://localhost:8080/api/v1/products";

// Task: Fetch Data from Database via API
async function fetchProducts() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Database Connection Failed");
        
        const products = await response.json();
        renderProductList(products);
        updateFeaturedAndDiscounts(products);
    } catch (error) {
        console.error("Error fetching products:", error);
    }
}

function renderProductList(products) {
    const container = document.querySelector('.product-list');
    if (!container) return;

    container.innerHTML = products.map(p => `
        <article class="product-card" data-id="${p.id}">
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

function updateFeaturedAndDiscounts(products) {
    // Logic for Featured/Discount sections if they exist on the page
    const featured = document.getElementById('featured');
    if (featured && products.length > 0) {
        // You can pick a specific product to feature
    }
}

// Initialized App
document.addEventListener('DOMContentLoaded', () => {
    fetchProducts();

    // User Greeting
    const greeting = document.getElementById('user-greeting');
    if (greeting) greeting.textContent = "Rence A. Escala & Lyza Atencio";
});

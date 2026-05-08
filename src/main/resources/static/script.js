/* =====================================================
   PET PALACE - LABORATORY 9 (SECURITY & VALIDATION)
   Members: Rence A. Escala & Lyza Atencio
   ===================================================== */

const API_URL = "http://localhost:8080/api/v1/products";

// Task 7.1: Intercept Errors & Handle Sessions
async function fetchProducts() {
    try {
        const response = await fetch(API_URL);
        
        // Task 7.2: Redirect if not logged in
        if (response.status === 401) {
            alert("Please login to access Pet Palace.");
            window.location.href = "login.html";
            return;
        }

        if (!response.ok) throw new Error("Connection Failed");
        
        const products = await response.json();
        renderProductList(products);
    } catch (error) {
        console.error("Error:", error);
    }
}

// Task 3.1: Admin-only delete action
async function deleteProduct(id) {
    const response = await fetch(`${API_URL}/${id}`, { method: 'DELETE' });

    if (response.status === 403) {
        alert("Access Denied: Only Admins can delete products.");
    } else if (response.ok) {
        alert("Product deleted successfully.");
        fetchProducts();
    }
}

function renderProductList(products) {
    const container = document.querySelector('.product-list');
    if (!container) return;

    container.innerHTML = products.map(p => `
        <article class="product-card">
            <img src="${p.imageUrl}" alt="${p.name}">
            <h3>${p.name}</h3>
            <p class="price">₱${p.price.toFixed(2)}</p>
            <div class="card-buttons">
                <button class="btn" onclick="addToCart(${p.id})">Add to Cart</button>
                <button class="btn delete-btn" onclick="deleteProduct(${p.id})">Delete</button>
            </div>
        </article>
    `).join('');
}

document.addEventListener('DOMContentLoaded', fetchProducts);

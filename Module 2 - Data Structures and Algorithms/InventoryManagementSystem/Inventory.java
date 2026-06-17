import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Add product - Time Complexity: O(1)
    public void addProduct(Product product) {
        if (products.containsKey(product.getProductId())) {
            System.out.println("Product ID already exists. Use update instead.");
            return;
        }
        products.put(product.getProductId(), product);
        System.out.println("Added product: " + product.getProductName());
    }

    // Update product - Time Complexity: O(1)
    public void updateProduct(String productId, int quantity, double price) {
        Product product = products.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Updated product: " + product.getProductName());
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    // Delete product - Time Complexity: O(1)
    public void deleteProduct(String productId) {
        Product removed = products.remove(productId);
        if (removed != null) {
            System.out.println("Deleted product: " + removed.getProductName());
        } else {
            System.out.println("Product not found with ID: " + productId);
        }
    }

    // Traverse and display - Time Complexity: O(N)
    public void displayInventory() {
        if (products.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("--- Current Inventory ---");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}

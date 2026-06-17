public class InventoryTest {
    public static void main(String[] args) {
        Inventory warehouse = new Inventory();

        Product p1 = new Product("P001", "Laptop", 10, 999.99);
        Product p2 = new Product("P002", "Smartphone", 25, 499.99);
        Product p3 = new Product("P003", "Headphones", 50, 79.99);

        System.out.println("--- Testing Inventory Management System ---");
        // Add Products
        warehouse.addProduct(p1);
        warehouse.addProduct(p2);
        warehouse.addProduct(p3);
        warehouse.displayInventory();

        // Update Product
        System.out.println("\nUpdating Smartphone inventory:");
        warehouse.updateProduct("P002", 30, 479.99);
        warehouse.displayInventory();

        // Delete Product
        System.out.println("\nDeleting Headphones inventory:");
        warehouse.deleteProduct("P003");
        warehouse.displayInventory();
    }
}

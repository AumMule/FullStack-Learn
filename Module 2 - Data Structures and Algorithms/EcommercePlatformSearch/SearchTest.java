import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Chair", "Furniture"),
            new Product("P004", "Book", "Education"),
            new Product("P005", "Desk", "Furniture")
        };

        System.out.println("--- Testing Search Algorithms ---");

        // 1. Linear Search on unsorted array
        System.out.println("Executing Linear Search for 'Chair':");
        Product foundLinear = SearchAlgorithms.linearSearch(products, "Chair");
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Product Not Found"));

        // 2. Binary Search requires sorted array
        System.out.println("\nSorting array for Binary Search...");
        Arrays.sort(products); // Sorted by name using compareTo
        for (Product p : products) {
            System.out.println(p);
        }

        System.out.println("\nExecuting Binary Search for 'Chair':");
        Product foundBinary = SearchAlgorithms.binarySearch(products, "Chair");
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Product Not Found"));

        System.out.println("\nExecuting Binary Search for non-existent 'Tablet':");
        Product notFoundBinary = SearchAlgorithms.binarySearch(products, "Tablet");
        System.out.println("Result: " + (notFoundBinary != null ? notFoundBinary : "Product Not Found"));
    }
}

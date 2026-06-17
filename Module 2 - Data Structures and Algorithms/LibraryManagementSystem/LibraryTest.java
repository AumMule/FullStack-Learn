import java.util.Arrays;

public class LibraryTest {
    public static void main(String[] args) {
        Book[] books = {
            new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Moby Dick", "Herman Melville"),
            new Book("B005", "The Catcher in the Rye", "J.D. Salinger")
        };

        System.out.println("--- Testing Library Search System ---");

        // 1. Linear Search
        System.out.println("Executing Linear Search for '1984':");
        Book foundLinear = Library.linearSearchByTitle(books, "1984");
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Book Not Found"));

        // 2. Binary Search
        System.out.println("\nSorting library catalog for Binary Search...");
        Arrays.sort(books); // Sort by title
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nExecuting Binary Search for '1984':");
        Book foundBinary = Library.binarySearchByTitle(books, "1984");
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Book Not Found"));
    }
}

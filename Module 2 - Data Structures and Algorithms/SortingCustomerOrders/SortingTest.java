public class SortingTest {
    public static void main(String[] args) {
        Order[] ordersBubble = {
            new Order("O001", "Alice", 250.50),
            new Order("O002", "Bob", 120.00),
            new Order("O003", "Charlie", 450.00),
            new Order("O004", "David", 90.00),
            new Order("O005", "Emma", 300.20)
        };

        Order[] ordersQuick = ordersBubble.clone();

        System.out.println("--- Testing Sorting Algorithms ---");

        // 1. Bubble Sort
        System.out.println("Before Bubble Sort:");
        printOrders(ordersBubble);
        Sorter.bubbleSort(ordersBubble);
        System.out.println("\nAfter Bubble Sort:");
        printOrders(ordersBubble);

        System.out.println("\n----------------------------------");

        // 2. Quick Sort
        System.out.println("Before Quick Sort:");
        printOrders(ordersQuick);
        Sorter.quickSort(ordersQuick, 0, ordersQuick.length - 1);
        System.out.println("\nAfter Quick Sort:");
        printOrders(ordersQuick);
    }

    private static void printOrders(Order[] orders) {
        for (Order o : orders) {
            System.out.println(o);
        }
    }
}

public class TaskTest {
    public static void main(String[] args) {
        TaskLinkedList list = new TaskLinkedList();

        Task t1 = new Task("T001", "Design Database", "In Progress");
        Task t2 = new Task("T002", "Implement Authentication", "Pending");
        Task t3 = new Task("T003", "Write Unit Tests", "Pending");

        System.out.println("--- Testing Task Management System ---");
        
        // Add
        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);
        list.traverseTasks();

        // Search
        System.out.println("\nSearching for task ID T002:");
        Task found = list.searchTask("T002");
        System.out.println("Found: " + (found != null ? found : "Not Found"));

        // Delete
        System.out.println("\nDeleting task ID T001:");
        list.deleteTask("T001");
        list.traverseTasks();
    }
}

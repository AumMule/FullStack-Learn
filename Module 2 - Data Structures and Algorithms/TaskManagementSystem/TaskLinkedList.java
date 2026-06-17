public class TaskLinkedList {
    
    // Node representation
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    // Add Task to the end - Time Complexity: O(N)
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added Task: " + task.getTaskName());
    }

    // Search Task by ID - Time Complexity: O(N)
    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equals(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Traverse tasks - Time Complexity: O(N)
    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }
        System.out.println("--- Task List ---");
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Delete Task by ID - Time Complexity: O(N)
    public boolean deleteTask(String taskId) {
        if (head == null) {
            return false;
        }

        // If head contains the task to delete
        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            System.out.println("Deleted Task ID: " + taskId);
            return true;
        }

        Node current = head;
        Node previous = null;

        while (current != null && !current.task.getTaskId().equals(taskId)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Task with ID " + taskId + " not found.");
            return false;
        }

        // Unlink the node
        previous.next = current.next;
        System.out.println("Deleted Task ID: " + taskId);
        return true;
    }
}

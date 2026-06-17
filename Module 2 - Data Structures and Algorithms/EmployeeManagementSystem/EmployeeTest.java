public class EmployeeTest {
    public static void main(String[] args) {
        EmployeeManager manager = new EmployeeManager(5);

        Employee e1 = new Employee("E001", "John Smith", "Manager", 75000);
        Employee e2 = new Employee("E002", "Jane Doe", "Developer", 60000);
        Employee e3 = new Employee("E003", "Bob Jones", "Designer", 50000);

        System.out.println("--- Testing Employee Management System ---");
        
        // Add
        manager.addEmployee(e1);
        manager.addEmployee(e2);
        manager.addEmployee(e3);
        manager.traverseEmployees();

        // Search
        System.out.println("\nSearching for employee ID E002:");
        Employee found = manager.searchEmployee("E002");
        System.out.println("Found: " + (found != null ? found : "Not Found"));

        // Delete
        System.out.println("\nDeleting employee ID E001:");
        manager.deleteEmployee("E001");
        manager.traverseEmployees();
    }
}

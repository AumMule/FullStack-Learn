public class EmployeeManager {
    private final Employee[] employees;
    private int size;

    public EmployeeManager(int capacity) {
        this.employees = new Employee[capacity];
        this.size = 0;
    }

    // Add Employee - Time Complexity: O(1) if space is available
    public boolean addEmployee(Employee emp) {
        if (size >= employees.length) {
            System.out.println("Error: Employee capacity full.");
            return false;
        }
        employees[size] = emp;
        size++;
        System.out.println("Added Employee: " + emp.getName());
        return true;
    }

    // Search Employee by ID - Time Complexity: O(N)
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees - Time Complexity: O(N)
    public void traverseEmployees() {
        if (size == 0) {
            System.out.println("No employees found.");
            return;
        }
        System.out.println("--- Employee List ---");
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    // Delete Employee by ID - Time Complexity: O(N) due to shifting
    public boolean deleteEmployee(String employeeId) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return false;
        }

        // Shift remaining elements left
        for (int i = index; i < size - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[size - 1] = null; // Clear last element
        size--;
        System.out.println("Deleted Employee ID: " + employeeId);
        return true;
    }
}

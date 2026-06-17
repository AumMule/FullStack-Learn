public class MVCTest {
    public static void main(String[] args) {
        // Fetch student record from database or create one mock student
        Student studentModel = retrieveStudentFromDatabase();

        // Create a view to write student details to console
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(studentModel, view);

        System.out.println("--- Testing MVC Pattern ---");
        System.out.println("Initial State:");
        controller.updateView();

        // Update model data via controller
        System.out.println("\nUpdating Student Grade from B to A+...");
        controller.setStudentGrade("A+");

        // Display updated record
        System.out.println("\nUpdated State:");
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        return new Student("Aum Patel", "S1001", "B");
    }
}

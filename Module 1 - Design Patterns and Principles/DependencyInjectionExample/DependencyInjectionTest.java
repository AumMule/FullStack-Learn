public class DependencyInjectionTest {
    public static void main(String[] args) {
        // Instantiate the concrete repository (Dependency)
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject dependency into service constructor (Constructor Injection)
        CustomerService service = new CustomerService(repository);

        System.out.println("--- Testing Dependency Injection ---");

        // Use the service to retrieve customers
        String customer1 = service.getCustomerName(1);
        String customer2 = service.getCustomerName(2);
        String customer3 = service.getCustomerName(99);

        System.out.println("Customer ID 1: " + customer1);
        System.out.println("Customer ID 2: " + customer2);
        System.out.println("Customer ID 99: " + customer3);
    }
}

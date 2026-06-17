public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public String findCustomerById(int id) {
        // Mock lookup logic
        if (id == 1) {
            return "Alice Smith";
        } else if (id == 2) {
            return "Bob Johnson";
        } else {
            return "Customer Not Found";
        }
    }
}

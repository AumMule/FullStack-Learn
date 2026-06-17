public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // 1. Pay using Credit Card
        PaymentStrategy ccStrategy = new CreditCardPayment(
                "Jane Doe", "1234567890123456", "123", "12/28"
        );
        context.setPaymentStrategy(ccStrategy);
        System.out.println("--- Testing Strategy Pattern ---");
        System.out.println("Paying for Shopping Cart Items:");
        context.executePayment(250.75);

        // 2. Pay using PayPal (runtime strategy switch)
        System.out.println("\nPaying for Subscription Services:");
        PaymentStrategy paypalStrategy = new PayPalPayment(
                "jane.doe@example.com", "mySecurePassword"
        );
        context.setPaymentStrategy(paypalStrategy);
        context.executePayment(45.00);
    }
}

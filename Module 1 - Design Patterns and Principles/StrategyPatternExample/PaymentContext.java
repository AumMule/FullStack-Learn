public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Allows setting strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("Error: Payment strategy not selected.");
            return;
        }
        paymentStrategy.pay(amount);
    }
}

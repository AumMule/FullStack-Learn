public class AdapterTest {
    public static void main(String[] args) {
        // Instantiate the original third-party gateways (Adaptees)
        PayPalGateway payPalGateway = new PayPalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        // Wrap them in their respective Adapters
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPalGateway);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripeGateway);

        // Process payments through the unified PaymentProcessor interface
        System.out.println("--- Testing Adapter Pattern ---");
        
        System.out.println("Processing payment using PayPal Adapter:");
        payPalProcessor.processPayment(150.00);
        
        System.out.println("\nProcessing payment using Stripe Adapter:");
        stripeProcessor.processPayment(275.50);
    }
}

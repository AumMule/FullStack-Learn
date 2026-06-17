public class DecoratorTest {
    public static void main(String[] args) {
        // Core notifier: Email only
        Notifier emailNotifier = new EmailNotifier();

        // Wrap with SMS
        Notifier smsAndEmail = new SMSNotifierDecorator(emailNotifier);

        // Wrap with Slack as well
        Notifier allChannels = new SlackNotifierDecorator(smsAndEmail);

        System.out.println("--- Testing Decorator Pattern ---");

        System.out.println("Scenario 1: Sending message via Email only:");
        emailNotifier.send("System maintenance alert.");

        System.out.println("\nScenario 2: Sending message via Email + SMS:");
        smsAndEmail.send("Critical system alert!");

        System.out.println("\nScenario 3: Sending message via Email + SMS + Slack:");
        allChannels.send("Emergency: Server is down!");
    }
}

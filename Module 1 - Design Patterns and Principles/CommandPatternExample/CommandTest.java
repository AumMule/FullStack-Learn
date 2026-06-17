public class CommandTest {
    public static void main(String[] args) {
        // Create Receiver
        Light livingRoomLight = new Light();

        // Create Concrete Commands
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Create Invoker
        RemoteControl remote = new RemoteControl();

        System.out.println("--- Testing Command Pattern ---");

        // Set and execute Light On
        System.out.println("Pressing button to turn light ON:");
        remote.setCommand(lightOn);
        remote.pressButton();

        // Set and execute Light Off
        System.out.println("\nPressing button to turn light OFF:");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}

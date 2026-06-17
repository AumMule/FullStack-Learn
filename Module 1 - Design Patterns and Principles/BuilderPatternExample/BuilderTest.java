public class BuilderTest {
    public static void main(String[] args) {
        // Build a basic office Computer with only required attributes
        Computer officePC = new Computer.Builder("Intel Core i3", "8GB", "256GB SSD")
                .build();

        // Build a gaming Computer with GPU and Bluetooth enabled
        Computer gamingPC = new Computer.Builder("AMD Ryzen 7", "32GB", "1TB NVMe SSD")
                .setGPUEnabled(true)
                .setBluetoothEnabled(true)
                .build();

        // Build a server Computer with GPU disabled but Bluetooth enabled
        Computer serverPC = new Computer.Builder("Intel Xeon", "64GB", "4TB HDD RAID")
                .setBluetoothEnabled(true)
                .build();

        // Display configurations
        System.out.println("--- Testing Builder Pattern ---");
        System.out.println("Office PC: " + officePC);
        System.out.println("Gaming PC: " + gamingPC);
        System.out.println("Server PC: " + serverPC);
    }
}

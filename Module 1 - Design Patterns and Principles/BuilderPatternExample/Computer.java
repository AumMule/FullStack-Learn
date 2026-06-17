public class Computer {
    // Attributes
    private final String CPU;
    private final String RAM;
    private final String storage;
    
    // Optional parts
    private final boolean isGPUEnabled;
    private final boolean isBluetoothEnabled;

    // Private constructor taking Builder as a parameter
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.isGPUEnabled = builder.isGPUEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public boolean isGPUEnabled() { return isGPUEnabled; }
    public boolean isBluetoothEnabled() { return isBluetoothEnabled; }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage 
                + ", GPU=" + (isGPUEnabled ? "Enabled" : "Disabled") 
                + ", Bluetooth=" + (isBluetoothEnabled ? "Enabled" : "Disabled") + "]";
    }

    // Static nested Builder class
    public static class Builder {
        // Required attributes
        private final String CPU;
        private final String RAM;
        private final String storage;

        // Optional attributes (defaulted to false/null)
        private boolean isGPUEnabled = false;
        private boolean isBluetoothEnabled = false;

        // Constructor for required fields
        public Builder(String CPU, String RAM, String storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.storage = storage;
        }

        // Setter methods returning the Builder instance for chaining
        public Builder setGPUEnabled(boolean isGPUEnabled) {
            this.isGPUEnabled = isGPUEnabled;
            return this;
        }

        public Builder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        // Build method to construct and return the Computer instance
        public Computer build() {
            return new Computer(this);
        }
    }
}

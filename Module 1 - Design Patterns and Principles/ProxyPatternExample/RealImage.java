public class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading " + fileName + " from remote server...");
        try {
            // Mock server loading delay
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(fileName + " loaded successfully.");
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

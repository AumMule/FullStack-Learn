public class ProxyImage implements Image {
    private final String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // Lazy initialization & Caching
        if (realImage == null) {
            realImage = new RealImage(fileName);
        } else {
            System.out.println("(Retrieved " + fileName + " from Cache)");
        }
        realImage.display();
    }
}

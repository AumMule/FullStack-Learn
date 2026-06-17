public class ProxyTest {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo_sunset.jpg");
        Image image2 = new ProxyImage("chart_financial.png");

        System.out.println("--- Testing Proxy Pattern ---");

        // First display: image will load from remote server
        System.out.println("First call to display image1:");
        image1.display();
        System.out.println();

        // Second display: image should be cached and loaded instantly
        System.out.println("Second call to display image1 (should use caching):");
        image1.display();
        System.out.println();

        // First display of image2
        System.out.println("First call to display image2:");
        image2.display();
        System.out.println();

        // Second display of image2
        System.out.println("Second call to display image2 (should use caching):");
        image2.display();
    }
}

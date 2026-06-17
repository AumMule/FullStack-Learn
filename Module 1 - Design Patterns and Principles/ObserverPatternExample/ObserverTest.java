public class ObserverTest {
    public static void main(String[] args) {
        // Create concrete subject
        StockMarket googleStock = new StockMarket("GOOGL", 1750.00);

        // Create concrete observers
        Observer mobileApp1 = new MobileApp("AndroidClient1");
        Observer mobileApp2 = new MobileApp("iOSClient");
        Observer webDashboard = new WebApp("AdminPortal");

        System.out.println("--- Testing Observer Pattern ---");

        // Register observers
        googleStock.registerObserver(mobileApp1);
        googleStock.registerObserver(mobileApp2);
        googleStock.registerObserver(webDashboard);

        // Change stock price (all observers should be notified)
        googleStock.setPrice(1755.50);

        // Deregister one observer
        System.out.println();
        googleStock.deregisterObserver(mobileApp2);

        // Change stock price again (remaining observers should be notified)
        googleStock.setPrice(1762.10);
    }
}

public class WebApp implements Observer {
    private final String clientName;

    public WebApp(String clientName) {
        this.clientName = clientName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp Dashboard [" + clientName + "] - Stock: " + stockName + " is now $" + price);
    }
}

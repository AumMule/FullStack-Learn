import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private final List<Observer> observers;
    private final String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.observers = new ArrayList<>();
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void setPrice(double newPrice) {
        System.out.println("\n[Market Update] " + stockName + " price changed to $" + newPrice);
        this.price = newPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
        System.out.println("Registered observer: " + observer.getClass().getSimpleName());
    }

    @Override
    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Deregistered observer: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }
}

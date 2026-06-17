public class ForecastingTest {
    public static void main(String[] args) {
        double initialInvestment = 1000.00; // Present Value
        double growthRate = 0.05;           // 5% annual growth rate
        int years = 10;                     // Forecast periods

        System.out.println("--- Testing Financial Forecasting ---");
        System.out.println("Initial Value: $" + initialInvestment);
        System.out.println("Growth Rate  : " + (growthRate * 100) + "%");
        System.out.println("Periods      : " + years + " years");

        double futureValue = Forecasting.calculateFutureValue(initialInvestment, growthRate, years);
        
        System.out.printf("\nPredicted Future Value after %d years: $%.2f%n", years, futureValue);
    }
}

public class Forecasting {

    /**
     * Calculates Future Value recursively.
     * Formula: FV = PV * (1 + rate)^periods
     * 
     * Time Complexity: O(N) where N is the number of periods.
     * Space Complexity: O(N) recursive call stack space.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: no more periods left to forecast
        if (periods == 0) {
            return presentValue;
        }
        
        // Recursive step: compound present value by 1 year of growth
        return calculateFutureValue(presentValue * (1 + growthRate), growthRate, periods - 1);
    }
}

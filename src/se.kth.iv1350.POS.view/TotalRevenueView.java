package src.se.kth.iv1350.POS.view;


import src.se.kth.iv1350.POS.model.SaleObserver;

/**
 * This is the class which will show the total amount paid for purchases since the program started.
 */
class TotalRevenueView implements SaleObserver {
    private double totalRevenue;

    TotalRevenueView() {
        totalRevenue = 0;
    }

    /**
     * This is the function which updates totalRevenue and prints it to the console.
     * @param priceOfPurchase
     */
    @Override
    public void newSale(double priceOfPurchase) {
    totalRevenue += priceOfPurchase;
    System.out.println("Total revenue since the program started is: " + totalRevenue);
    }
}

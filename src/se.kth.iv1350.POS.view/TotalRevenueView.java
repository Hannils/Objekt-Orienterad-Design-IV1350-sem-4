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

    @Override
    public void newSale(double priceOfPurchase) {
    totalRevenue += priceOfPurchase;
    System.out.println("Total revenue since the program started is: " + totalRevenue);
    }
}

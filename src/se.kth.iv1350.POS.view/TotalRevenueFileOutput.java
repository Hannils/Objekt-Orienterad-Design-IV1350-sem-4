package src.se.kth.iv1350.POS.view;

import src.se.kth.iv1350.POS.model.SaleObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Prints the total income sine the program started to a file.
 */
 class TotalRevenueFileOutput implements SaleObserver {
     private double totalRevenue;
     private PrintWriter logFile;

    TotalRevenueFileOutput() {
        totalRevenue = 0;
        try {
            logFile = new PrintWriter(new FileWriter("total-revenue.txt"), true);
        } catch (IOException ex) {
            System.out.println("Could not create logger.");
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param priceOfPurchase
     */
    public void newSale(double priceOfPurchase) {
        totalRevenue += priceOfPurchase;
        logFile.println("total revenue: " + totalRevenue);
    }
}


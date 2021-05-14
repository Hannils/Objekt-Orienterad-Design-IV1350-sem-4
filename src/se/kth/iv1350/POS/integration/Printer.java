package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.model.Item;
import src.se.kth.iv1350.POS.model.Receipt;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the printer from the integration package.
 */
public class Printer {

  /**
   * This is the function which prints the receipt.
   * @param receipt This is the parameter receipt which contains information.
   */
  public void printReceipt(Receipt receipt, Sale sale) {
    String storeinformation = receipt.getStoreInformation();
    System.out.println("*****************************************");
    System.out.println(storeinformation);
    System.out.println(sale.getSaleTime() + "               " + sale.getDate()+"\n");
    for(Item item : sale.getItems())
      System.out.println(item.toString());
    sale.updatePrices();
    System.out.println("ATT BETALA        " + sale.getTotalPrice());
    System.out.println("MOMS              " + sale.getTotalVAT());
    System.out.println("*****************************************");
  }
}

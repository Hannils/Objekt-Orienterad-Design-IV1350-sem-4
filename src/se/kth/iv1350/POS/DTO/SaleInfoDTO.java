package src.se.kth.iv1350.POS.DTO;

/**
 * This is the class which holds information about the current sale.
 */
public class SaleInfoDTO {
  private String currentItemDescription;
  private double currentItemPrice;
  private String currentItemName;
  private double runningTotal;

  /**
   * This is the constructor for the Sale information Data Transfer Object
   * @param item This is the parameter which the information about the current item is held.
   * @param runningTotal This is the information about the current price for the current sale.
   */
  public SaleInfoDTO(ItemDTO item, double runningTotal) {
    this.currentItemDescription = item.getDescription();
    this.currentItemPrice = item.getPrice() + item.getPrice() * item.getVAT();
    this.currentItemName = item.getName();
    this.runningTotal = runningTotal;
  }

  /**
   * This is the function which will return the item description specified.
   * @return This returns the value specified above
   */
  public String getItemDescription() {
    return this.currentItemDescription;
  }
  /**
   * This is the function which will return the item price specified.
   * @return This returns the value specified above
   */
  public double getCurrentItemPrice() {
    return this.currentItemPrice;
  }
  /**
   * This is the function which will return the item name specified.
   * @return This returns the value specified above
   */
  public String getCurrentItemName() {
    return this.currentItemName;
  }
  /**
   * This is the function which will return the current running total.
   * @return This returns the value specified above
   */
  public double getRunningTotal() {
    return this.runningTotal;
  }
}

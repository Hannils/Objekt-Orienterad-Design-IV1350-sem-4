package src.se.kth.iv1350.POS.model;

import src.se.kth.iv1350.POS.DTO.ItemDTO;

/**
 * This is the item class from the model package.
 */
public class Item {
  private String name;
  private double VAT;
  private double price;
  private String description;
  private int weight;
  private int quantity;

  /**
   * This is the constructor for the item class. It takes in several parameters.
   * @param itemDTO This is a parameter which holds information about an item.
   * @param quantity This is a parameter which says how many of a specific item to add to the sale.
   */
  public Item(ItemDTO itemDTO, int quantity){
    this.name = itemDTO.getName();
    this.VAT = itemDTO.getVAT();
    this.description = itemDTO.getDescription();
    this.quantity = quantity;
    this.price = itemDTO.getPrice() * this.quantity;
    this.weight = weight;
  }

  /**
   * This is the function which will return the name of the item.
   * @return
   */
  public String getName() {
    return this.name;
  }

  /**
   * This is the function which will return the VAT of the item.
   * @return
   */
  public double getVAT() {
    return this.VAT;
  }

  /**
   * This is the function which will return the price of the item.
   * @return
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * This is the function which will return the description of the item.
   * @return
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * This is the function which will return the weight of the item.
   * @return
   */
  public int getWeight() {
    return this.weight;
  }

  /**
   * This is the function which will return the quantity of the item.
   * @return
   */
  public int getQuantity() {
    return this.quantity;
  }

  /**
   * This function sets the way the object item is to be printed.
   * @return
   */
  @Override
  public String toString() {
    return "("+this.quantity+"x, "+this.name +", "+ this.getDescription()+
            ", PRIS:"+this.getPrice()+"kr, MOMS:"+ this.getVAT()*this.getPrice() +"kr)\n";
  }
}

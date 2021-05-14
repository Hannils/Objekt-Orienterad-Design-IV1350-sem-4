package src.se.kth.iv1350.POS.DTO;

/**
 * This is the class which holds and only holds information about an item.
 */
public class ItemDTO {
  private String description;
  private double VAT;
  private double price;
  private String name;
  private String identifier;

  /**
   * This is the constructor for the ItemDTO which holds information about an item.
   * @param description This parameter contains the description about the item.
   * @param VAT This parameter contains the amount of value added tax which is applied to the item.
   * @param price This parameter contains the price for the item.
   * @param name This parameter contains the name for the item.
   */
  public ItemDTO(String description, double VAT, double price, String name, String identifier) {
    this.description = description;
    this.VAT = VAT;
    this.price = price;
    this.name = name;
    this.identifier = identifier;
  }

  /**
   * This is the function which returns the description for the item.
   * @return This returns the value specified above
   */
  public String getDescription(){
    return this.description;
  }
  /**
   * This is the function which returns the description for the item.
   * @return This returns the value specified above
   */
  public double getVAT() {
    return this.VAT;
  }
  /**
   * This is the function which returns the description for the item.
   * @return This returns the value specified above
   */
  public double getPrice() {
    return this.price;
  }
  /**
   * This is the function which returns the description for the item.
   * @return This returns the value specified above
   */
  public String getName() {
    return this.name;
  }

  /**
   * This is the function which return the identifier for the item.
   * @return The identifier.
   */
  public String getIdentifier() {
    return this.identifier;
  }

}

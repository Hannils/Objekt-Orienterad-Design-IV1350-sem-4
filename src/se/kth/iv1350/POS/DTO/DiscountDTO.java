package src.se.kth.iv1350.POS.DTO;

/**
 * This is class in which the discount DTO is defined.
 */
public class DiscountDTO {
    private final String type;
    private String idForDiscountedItem;
    private double amount;
    private double minRequiredPrice;

    /**
     * This is the class which defines the item-discount.
     * @param idForDiscountedItem This is the identifier specified for the discounted item.
     * @param amount This is the amount of discount for the specified item.
     */
    public DiscountDTO(String idForDiscountedItem, double amount) {
        type = "item";
        this.idForDiscountedItem = idForDiscountedItem;
        this.amount = amount;
    }

    /**
     * This is the function which defines the sale-discount.
     * @param amount This is the amount of discount for the specified sale.
     * @param minRequiredPrice This is the minimum required price for a sale discount to be applied.
     */
    public DiscountDTO(double amount, double minRequiredPrice) {
        type = "sale";
        this.amount = amount;
        this.minRequiredPrice = minRequiredPrice;
    }

    /**
     * This is the function which returns the identifier for the specified discounted item.
     * @return The identifier for the discounted item.
     */
    public String getIdForDiscountedItem() {
        return this.idForDiscountedItem;
    }

    /**
     * This is the function which returns the type of discount.
     * @return The type for the discount.
     */
    public String getType() {
        return this.type;
    }

    /**
     * This is the function which returns the amount specified for the discount.
     * @return The amount specified for the discount.
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * This is the function which returns the minimum require price for the sale discount.
     * @return The minimum required price for the sale discount.
     */
    public double getMinRequiredPrice() {
        return this.minRequiredPrice;
    }
}

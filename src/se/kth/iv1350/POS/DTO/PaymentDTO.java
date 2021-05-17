package src.se.kth.iv1350.POS.DTO;

/**
 * This is the class which holds information about a payement
 */
public class PaymentDTO {
  private double amount;
  private String currency;

  /**
   * This is the constructor for the payment data transfer object which takes in two parameters.
   * @param amount This is the parameter which specifies how much of a certain currency is being paid.
   * @param currency This is the parameter which specifies what currency is used in the payment.
   */
  public PaymentDTO(int amount, String currency) {
    this.amount = amount;
    this.currency = currency;
  }

  /**
   * This is the function which returns the amount used in the payment.
   * @return
   */
  public double getAmount() {
    return this.amount;
  }

  /**
   * This is the function which returns the currency used in the payment.
   * @return
   */
  public String getCurrency() {
    return this.currency;
  }

  /**
   * This is the function that specifies how a paymentDTO is supposed to be written out.
   * @return The way a paymentDTO is supposed to be written out.
   */
  @Override
  public String toString() {
    return this.amount + " " + this.currency;
  }
}

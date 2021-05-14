package src.se.kth.iv1350.POS.model;

import src.se.kth.iv1350.POS.DTO.PaymentDTO;

/**
 * Represents one receipt, which proves the payment of one sale.
 */
public class Receipt {
  private Sale sale;
  private PaymentDTO payment;
  private String storeInformation = "ICA KTH KÖKSBANKEN, RUNDA-SLÄNGEN 69 420C4";

  /**
   * This is the constructor for the class receipt.
   * @param sale This is the parameter which contains information about the current sale.
   * @param payment This is the parameter which contains information about the payment.
   */
  public Receipt(Sale sale, PaymentDTO payment) {
    this.sale = sale;
    this.payment = payment;
    this.storeInformation = storeInformation;
  }

  /**
   * This is the function which returns the current sale from the receipt.
   * @return
   */
  public Sale getSale() {
    return this.sale;
  }

  /**
   * This is the function which returns the payment from the receipt as an PaymentDTO.
   * @return
   */
  public PaymentDTO getPayment() {
    return this.payment;
  }

  /**
   * This is the function which returns the stores information from the receipt.
   * @return
   */
  public String getStoreInformation() {
    return this.storeInformation;
  }
}


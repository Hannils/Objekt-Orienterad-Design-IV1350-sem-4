package src.se.kth.iv1350.POS.view;

import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.controller.Controller;
import src.se.kth.iv1350.POS.integration.ItemNotFoundException;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution
 * with calls to all system operations in the controller
 */
public class View {
  private Controller contr;
  private String identifier;
  private int amount;
  private String currency;

  /**
   * Creates a new instance, that uses the specified controller for all calls to other layers.
   * @param contr The controller to use for all calls other layers.
   */
  public View(Controller contr) {
	this.contr = contr;
  }

  /**
   * Performs a fake sale, by calling all system operations in the controller.
   */
  public void runFakeExecution() {
	contr.startSale();
	System.out.println("A new sale has been started.");
	try {
        SaleInfoDTO saleInformation = contr.enterItem("first");
        saleInformation = contr.enterItem("third");
        saleInformation = contr.enterItem("first");
        PaymentDTO payment = contr.pay(amount, currency);
        System.out.println("Change: " + payment);
    } catch(ItemNotFoundException itemNotFound) {
	    System.err.println("Invalid identifier entered, no item found. " + itemNotFound);
    }

  }

}
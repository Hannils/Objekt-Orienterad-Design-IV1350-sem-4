package src.se.kth.iv1350.POS.view;

import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.controller.Controller;
import src.se.kth.iv1350.POS.integration.ItemNotFoundException;
import src.se.kth.iv1350.POS.integration.ServerDownException;

/**
 * This is a placeholder for the real view. It contains a hardcoded execution
 * with calls to all system operations in the controller
 */
public class View {
  private Controller contr;
  private String identifier;
  private int amount = 100;
  private String currency = "kr";
  private SaleInfoDTO saleInformation;

  /**
   * Creates a new instance, that uses the specified controller for all calls to other layers.
   * @param contr The controller to use for all calls other layers.
   */
  public View(Controller contr) {
	this.contr = contr;
	contr.addSaleObserver(new TotalRevenueFileOutput());
      contr.addSaleObserver(new TotalRevenueView());
  }

  /**
   * Performs a fake sale, by calling all system operations in the controller.
   */
  public void runFakeExecution() {
	contr.startSale();
	System.out.println("A new sale has been started.");
	try {
        contr.enterItem("first");
        contr.enterItem("third");
        saleInformation = contr.enterItem("first");
    } catch(ItemNotFoundException itemNotFound) {
	    System.err.println("Invalid identifier, item not found.");
    } catch (ServerDownException serverDown) {
	    System.err.println("Server not reachable");
    }
	  contr.applyDiscount();
      PaymentDTO change = contr.pay(amount, currency);
      System.out.println("Change: " + change);

  }

}
package src.se.kth.iv1350.POS.controller;

import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.integration.EASHandler;
import src.se.kth.iv1350.POS.integration.EISHandler;
import src.se.kth.iv1350.POS.integration.ItemNotFoundException;
import src.se.kth.iv1350.POS.integration.Printer;
import src.se.kth.iv1350.POS.model.Item;
import src.se.kth.iv1350.POS.model.Receipt;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller {
  private EISHandler eis;
  private EASHandler eas;
  private Printer printer;
  private Sale sale;

  /**
   * The applications only controller which takes several parameters.
   * @param eas This is the external accounting system parameter.
   * @param eis This is the external inventory system parameter.
   * @param printer This is the printer parameter.
   */
  public Controller(EISHandler eis, EASHandler eas, Printer printer){
    this.eis = eis;
	this.eas = eas;
    this.printer = printer;

    //For testing purposes
    System.out.println("Controller started successfully");
  }

  /**
   * Starts a new sale. This method must be called before doing anything else during a sale.
   */
  public void startSale() {
	sale = new Sale();
  }

  /**
   * This is the function which will enter an item to the current sale. It takes in one parameter.
   * @param identifier This is the parameter which identifies the item entered.
   * @return
   */
  public SaleInfoDTO enterItem(String identifier) throws ItemNotFoundException {
    try {
      ItemDTO itemDTO = eis.findItem(identifier);
      SaleInfoDTO saleInformation = sale.addItem(itemDTO);
      System.out.println("Item " + identifier + " has been added");
      return saleInformation;
    } catch(ItemNotFoundException itemNotFound) {
      System.out.println("For developers: " + itemNotFound);
      throw itemNotFound;
    }

  }

  /**
   * This is the function in which payment will be recieved and sale will be completed.
   * @param amount This is the parameter which specifies the amount of currency taken in.
   * @param currency This is the parameter which specifies which currency has been accepted.
   * @return
   */
  public PaymentDTO pay(int amount, String currency) {
    PaymentDTO payment = new PaymentDTO(amount, currency);

    Receipt receipt = sale.complete(payment, sale);
    eas.registerPayment(payment, sale);
    eis.updateInventory(sale);
    printer.printReceipt(receipt, sale);
    return payment;
  }



}
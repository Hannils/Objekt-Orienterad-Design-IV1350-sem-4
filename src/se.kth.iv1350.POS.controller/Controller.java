package src.se.kth.iv1350.POS.controller;

import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.integration.*;
import src.se.kth.iv1350.POS.model.Item;
import src.se.kth.iv1350.POS.model.Receipt;
import src.se.kth.iv1350.POS.model.Sale;
import src.se.kth.iv1350.POS.model.SaleObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the application's only controller. All calls to the model pass through this class.
 */
public class Controller {
  private EISHandler eis;
  private EASHandler eas;
  private Printer printer;
  private Sale sale;
  private List<SaleObserver> saleObservers = new ArrayList<>();

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
	for (SaleObserver obs : saleObservers) {
	  sale.addSaleObserver(obs);
    }
  }

  /**
   * This is the function which will enter an item to the current Sale. It takes in one parameter.
   * @param identifier This is the parameter which identifies the item entered.
   * @return The saleInformation.
   * @throws ItemNotFoundException if the entered identifier is not found in inventory.
   * @throws ServerDownException if the database is down or unreachable.
   */
  public SaleInfoDTO enterItem(String identifier) throws ItemNotFoundException, ServerDownException {
    try {
      ItemDTO itemDTO = eis.findItem(identifier);
      SaleInfoDTO saleInformation = sale.addItem(itemDTO);
      System.out.println("Item " + identifier + " has been added");
      return saleInformation;
    } catch (ItemNotFoundException | ServerDownException exception) {
      System.out.println("For developers: " + exception.getMessage());
      throw exception;
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

  public void addSaleObserver(SaleObserver saleObserver) {
    saleObservers.add(saleObserver);
  }
}
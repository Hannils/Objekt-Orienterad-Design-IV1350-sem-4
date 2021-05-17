package src.se.kth.iv1350.POS.model;

import src.se.kth.iv1350.POS.DTO.DiscountDTO;
import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
  private LocalTime saleTime;
  private LocalDate date;
  private ArrayList<Item> items = new ArrayList<Item>();
  private Item createdItem;
  private double totalPrice;
  private double totalVAT;
  private double runningTotal = totalPrice + totalVAT;
  private List <SaleObserver> saleObservers = new ArrayList<>();

  /**
   * Creates a new instance and saves the time for the sale.
   */
  public Sale() {
	this.saleTime = LocalTime.now();
	this.date = LocalDate.now();
	this.totalPrice = totalPrice;
	this.totalVAT = totalVAT;
  }

  /**
   * This function creates a new item and adds its price to the running total then proceeds to create a
   * Sale Information Data Transfer Object and returns it.
   * @param itemDTO
   * @return
   */
  public SaleInfoDTO addItem(ItemDTO itemDTO) {
    Item createdItem = new Item(itemDTO, 1);
    for(int i = 0; i < items.size(); i++){
      if(createdItem.getName().equals(items.get(i).getName())){
        createdItem = new Item(itemDTO, items.get(i).getQuantity() + 1);
        items.remove(i);
      }
    }
    items.add(createdItem);
    updatePrices();
	SaleInfoDTO saleInformation = new SaleInfoDTO(itemDTO, runningTotal);
	return saleInformation;
  }

  /**
   * This function calculates the running total price based on the price of the item scanned and the VAT of that item.
   */
  public void updatePrices() {
    this.totalPrice = 0;
    this.totalVAT = 0;
    for(Item item : items) {
      this.totalPrice += item.getPrice();
      this.totalVAT += (item.getVAT() * item.getPrice());
    }
    this.runningTotal = this.totalPrice + this.totalVAT;
  }

  /**
   * This is the function which completes the sale and accepts payment. It takes in several parameters.
   * @param payment This is the parameter which takes in the payment recieved.
   * @param sale This is the parameter which takes in the current sale.
   * @return
   */
  public Receipt complete(PaymentDTO payment, Sale sale) {
    Receipt receipt = new Receipt(sale, payment);
    notifyObservers();
    return receipt;
  }

  private void notifyObservers() {
    for(SaleObserver obs : saleObservers) {
      obs.newSale(totalPrice);
    }
  }

  /**
   * Adds an observer. The observer will be notified when a sale is completed.
   * @param obs The observer to notify.
   */
  public void addSaleObserver(SaleObserver obs) {
    saleObservers.add(obs);
  }

  /**
   * This is the function which applies discount to the entire sale.
   * @param discounts This is the parameter that has information about the available disocunts.
   */
  public void applyDiscount(List<DiscountDTO> discounts) {
    for(DiscountDTO discount : discounts) {
      if(discount.getAmount() < 1)
        this.runningTotal *= discount.getAmount();
      else
        this.runningTotal -= discount.getAmount();
    }

  }

  /**
   * This is the function which applies discounts to items.
   * @param discounts This is the parameter which has information about available discounts.
   */
  public void applyItemDiscount(List<DiscountDTO> discounts) {
    for(DiscountDTO discount : discounts){
      for(Item item : items) {
        if(item.getIdentifier().equals(discount.getIdForDiscountedItem()))
          item.applyDiscount(discount);
      }
    }
    updatePrices();
  }
  /**
   * This is the function which return the time of the sale.
   * @return
   */
  public String getSaleTime() {
    return this.saleTime.getHour()+":"+this.saleTime.getMinute()+":"+this.saleTime.getSecond();
  }

  /**
   * This function returns the date of the sale.
   * @return
   */
  public LocalDate getDate() {
    return this.date;
  }

  /**
   * This is the function which returns the items of the sale.
   * @return
   */
  public ArrayList<Item> getItems() {
    return this.items;
  }

  /**
   * This is the function which returns the total price of the sale.
   * @return
   */
  public double getTotalPrice() {
    return this.totalPrice;
  }

  /**
   * This is the function which returns the total VAT of the sale.
   * @return
   */
  public double getTotalVAT() {
    return this.totalVAT;
  }

  /**
   * This is the function which return the running total of the sale.
   * @return
   */
  public double getRunningTotal() {
    return this.runningTotal;
  }
}

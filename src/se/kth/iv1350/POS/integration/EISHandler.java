package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the external inventory system handler from the integration package.
 */
public class EISHandler {
 private ItemDTO itemDTO;

  /**
   * This is the function which searches for an item with the parameter sent in.
   *
   * @param identifier This is the parameter which identifies the item entered.
   * @return
   */
  public ItemDTO findItem(String identifier) {
    switch (identifier) {
      case "first":
        itemDTO = new ItemDTO("Ris", 0.25, 15, "Uncle Ben's 1 minute rice");
        return itemDTO;

      case "second":
        itemDTO = new ItemDTO("Dryck", 0.25, 10, "Coca Cola");
        return itemDTO;

      case "third":
        itemDTO = new ItemDTO("Tobak", 0.5, 33.90, "Knox Stark");
        return itemDTO;
    }
    return null;
  }

  /**
   * This is the function which updates the inventory based on the parameter sent in.
   * @param sale This is the parameter which get sent in order to update the inventory.
   */
  public void updateInventory(Sale sale) {
    System.out.println("Inventory has been updated!");
  }
}
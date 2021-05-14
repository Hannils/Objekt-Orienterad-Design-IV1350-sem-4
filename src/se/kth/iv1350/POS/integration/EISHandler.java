package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.model.Item;
import src.se.kth.iv1350.POS.model.Sale;
import java.util.ArrayList;

/**
 * This is the external inventory system handler from the integration package.
 */
public class EISHandler {
 private ItemDTO itemDTO;
 private ArrayList<ItemDTO> inventory = new ArrayList<ItemDTO>();
 private ItemDTO firstItemDTO;
 private ItemDTO secondItemDTO;
 private ItemDTO thirdItemDTO;

 public EISHandler() {
     firstItemDTO = new ItemDTO("Ris", 0.25, 15, "Uncle Ben's 1 minute rice", "first");
     secondItemDTO = new ItemDTO("Dryck", 0.25, 10, "Coca Cola", "second");
     thirdItemDTO = new ItemDTO("Tobak", 0.5, 33.90, "Knox Stark", "third");
     inventory.add(firstItemDTO);
     inventory.add(secondItemDTO);
     inventory.add(thirdItemDTO);
 }

  /**
   * This is the function which searches for an item with the parameter sent in.
   *
   * @param identifier This is the parameter which identifies the item entered.
   * @return
   */
  public ItemDTO findItem(String identifier) throws ItemNotFoundException {
      for (ItemDTO itemDTO : inventory){
          if(itemDTO.getIdentifier().equals(identifier)){
              return itemDTO;
          }
      }
      throw new ItemNotFoundException("Invalid identifier was entered, no item found.");
  }

  /**
   * This is the function which updates the inventory based on the parameter sent in.
   * @param sale This is the parameter which get sent in order to update the inventory.
   */
  public void updateInventory(Sale sale) {
    System.out.println("Inventory has been updated!");
  }
}
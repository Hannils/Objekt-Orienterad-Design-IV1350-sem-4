package src.se.kth.iv1350.POS.discount;

import src.se.kth.iv1350.POS.DTO.DiscountDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.model.Item;
import src.se.kth.iv1350.POS.model.Sale;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the class which defines itemDiscount and implements DiscountFinder
 */
public class ItemDiscount implements DiscountFinder {

    /**
     * This is the function which finds the discount.
     * @param sale The parameter sale is taken in to access the items in the sale.
     * @param availableDiscounts The parameter availableDiscounts is taken in to access all discounts available.
     * @return The found discounts.
     */
    @Override
    public List<DiscountDTO> findDiscount(Sale sale, List<DiscountDTO> availableDiscounts) {
        ArrayList<DiscountDTO> foundDiscounts = new ArrayList();
        for(DiscountDTO discount : availableDiscounts){
            for(Item item : sale.getItems()) {
                if(!discount.getType().equals("item")) continue;
                if(item.getIdentifier().equals(discount.getIdForDiscountedItem()))
                    foundDiscounts.add(discount);
            }
        }
        return foundDiscounts;
    }
}

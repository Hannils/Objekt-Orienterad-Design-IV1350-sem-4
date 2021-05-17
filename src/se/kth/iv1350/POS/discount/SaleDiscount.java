package src.se.kth.iv1350.POS.discount;

import src.se.kth.iv1350.POS.DTO.DiscountDTO;
import src.se.kth.iv1350.POS.model.Item;
import src.se.kth.iv1350.POS.model.Sale;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the class which defines sale discount and implements DiscountFinder.
 */
public class SaleDiscount implements DiscountFinder {

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
                if(!discount.getType().equals("sale")) continue;
                if(sale.getTotalPrice() >= discount.getMinRequiredPrice())
                    foundDiscounts.add(discount);
        }
        return foundDiscounts;
    }
}

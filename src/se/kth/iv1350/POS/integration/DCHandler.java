package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.DTO.DiscountDTO;
import src.se.kth.iv1350.POS.DTO.ItemDTO;
import src.se.kth.iv1350.POS.discount.DiscountFinder;
import src.se.kth.iv1350.POS.model.Item;
import src.se.kth.iv1350.POS.model.Sale;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the external discount handler for the program.
 */
public class DCHandler {
    private ArrayList<DiscountDTO> availableDiscounts = new ArrayList<DiscountDTO>();

    /**
     * This is the constructor for the DCHandler. It creates two pre-determined discounts and adds it
     * to the availableDiscounts array-list.
     */
    public DCHandler() {
        DiscountDTO firstItemDiscount = new DiscountDTO("first", 5);
        DiscountDTO firstSaleDiscount = new DiscountDTO(0.8, 50 );
        availableDiscounts.add(firstItemDiscount);
        availableDiscounts.add(firstSaleDiscount);
    }

    /**
     * This is the function which finds discounts.
     * @param sale The sale parameter is taken in to access all the items in the sale.
     * @param finder The finder parameter is taken in to access the findDiscount function in DiscountFinder.
     * @return The DiscountDTO list from the sale and available discounts.
     */
    public List<DiscountDTO> findDiscount(Sale sale, DiscountFinder finder) {
        return finder.findDiscount(sale, availableDiscounts);
    }
}
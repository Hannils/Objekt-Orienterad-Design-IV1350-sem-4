package src.se.kth.iv1350.POS.discount;

import src.se.kth.iv1350.POS.DTO.DiscountDTO;
import src.se.kth.iv1350.POS.DTO.SaleInfoDTO;
import src.se.kth.iv1350.POS.model.Sale;

import java.util.List;

/**
 * This is the interface for the discount finder.
 */
public interface DiscountFinder {
    List<DiscountDTO> findDiscount(Sale sale, List<DiscountDTO> availableDiscounts);
}

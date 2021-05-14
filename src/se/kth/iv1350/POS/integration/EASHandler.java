package src.se.kth.iv1350.POS.integration;

import src.se.kth.iv1350.POS.DTO.PaymentDTO;
import src.se.kth.iv1350.POS.model.Sale;

/**
 * This is the external accounting system handler form the integration package.
 */
public class EASHandler {
	/**
	 * This is the class which verifies that payment has been registered.
	 * @param payment The payment parameter contains the amount paid and its currency.
	 * @param sale The sale parameter contains all information about the sale.
	 */
	public void registerPayment(PaymentDTO payment, Sale sale) {
		System.out.println("Payment of " + payment.toString() + " has been registered");
	}
}

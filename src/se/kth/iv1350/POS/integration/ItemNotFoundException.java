package src.se.kth.iv1350.POS.integration;

/**
 * This is the exception thrown if an invalid identifier is entered or an item is not found.
 */
public class ItemNotFoundException extends Exception {

    /**
     * This is the constructor for ItemNotFoundException.
     * @param message This is the message which the exception will take in.
     */
    public ItemNotFoundException(String message) {
        super(message);
    }
}

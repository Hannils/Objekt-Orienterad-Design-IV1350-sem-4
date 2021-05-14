package src.se.kth.iv1350.POS.integration;


/**
 * This is the exception used for if a database is down or unreachable.
 */
public class ServerDownException extends Exception{
    /**
     * This is the constructor for the ServerDownException.
     * @param message This is the message which the exception will take in.
     */
    public ServerDownException(String message) {
        super(message);
    }
}

package exceptions;

/**
 * @author Bungardean Tudor-Ionut
 * @since 19.1.2
 */
public class ExceptionMessageCatalog {

    /**
     * BUYER EXCEPTION MESSAGES
     */
    public final static ExceptionMessage INVALID_NAME =
            new ExceptionMessage("BUYER-001", "Buyer's name has an invalid format");


    /**
     * GAME EXCEPTION MESSAGES
     */
    public final static ExceptionMessage INVALID_MATCH_FORMAT =
            new ExceptionMessage("GAME-001", "The match format is wrong");
}

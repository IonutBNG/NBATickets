package exceptions;

import javax.ejb.ApplicationException;

/**
 * @author Bungardean Tudor-Ionut
 * @since 19.1.2
 */
@ApplicationException(rollback = true)
public class BusinessException extends RuntimeException {

    /**
     * The message inside the exception.
     */
    private ExceptionMessage exceptionMessage;

    public BusinessException(final ExceptionMessage exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    /**
     * Getter.
     *
     * @return exceptionMessage
     */
    public ExceptionMessage getExceptionMessage() {
        return this.exceptionMessage;
    }
}


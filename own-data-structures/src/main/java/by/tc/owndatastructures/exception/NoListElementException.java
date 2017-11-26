package by.tc.owndatastructures.exception;

/**
 * Created by cplus on 26.11.2017.
 */
public class NoListElementException extends RuntimeException {
    private static final long serialVersionUID = 2963886680187772002L;

    public NoListElementException() {
    }

    public NoListElementException(String message) {
        super(message);
    }

    public NoListElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoListElementException(Throwable cause) {
        super(cause);
    }
}

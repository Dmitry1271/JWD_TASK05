package by.tc.owndatastructures.exception;

/**
 * Created by cplus on 25.11.2017.
 */
public class IndexOutListSizeException extends Exception{
    private static final long serialVersionUID = -4578223986297997887L;

    public IndexOutListSizeException() {
    }

    public IndexOutListSizeException(String message) {
        super(message);
    }

    public IndexOutListSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IndexOutListSizeException(Throwable cause) {
        super(cause);
    }
}

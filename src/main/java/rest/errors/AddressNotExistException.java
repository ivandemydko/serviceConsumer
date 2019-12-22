package rest.errors;

public class AddressNotExistException extends RuntimeException {

    public AddressNotExistException() {
        super();
    }

    public AddressNotExistException(String message) {
        super(message);
    }

    public AddressNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressNotExistException(Throwable cause) {
        super(cause);
    }
}

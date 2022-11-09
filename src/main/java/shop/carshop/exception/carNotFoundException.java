package shop.carshop.exception;

public class carNotFoundException extends RuntimeException{
    public carNotFoundException(String message) {
        super(message);
    }
}

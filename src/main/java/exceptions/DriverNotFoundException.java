package exceptions;

public class DriverNotFoundException extends Exception {

    public DriverNotFoundException(String browserName) {
        super(String.format("Browser %s not supported", browserName));
    }
}

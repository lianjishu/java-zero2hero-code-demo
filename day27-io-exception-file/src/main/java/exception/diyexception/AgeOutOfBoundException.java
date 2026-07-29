package exception.diyexception;

public class AgeOutOfBoundException extends RuntimeException {
    public AgeOutOfBoundException(String message) {
        super(message);
    }
}

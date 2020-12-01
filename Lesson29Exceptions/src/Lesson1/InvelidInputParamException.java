package Lesson1;

public class InvelidInputParamException extends RuntimeException {
    public InvelidInputParamException() {
    }

    public InvelidInputParamException(String message) {
        super(message);
    }

    public InvelidInputParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvelidInputParamException(Throwable cause) {
        super(cause);
    }
}

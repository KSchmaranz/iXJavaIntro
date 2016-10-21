package gol;

public class IllegalCellException extends RuntimeException {
    public IllegalCellException(String msg) {
        super(msg);
    }

    public IllegalCellException(String msg, Throwable cause) {
        super(msg, cause);
    }

}

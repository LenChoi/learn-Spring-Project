package jpabook.jpashop.exception;

public class NotEoughtStockException extends RuntimeException {

    public NotEoughtStockException() {
        super();
    }

    public NotEoughtStockException(String message) {
        super(message);
    }

    public NotEoughtStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEoughtStockException(Throwable cause) {
        super(cause);
    }

}

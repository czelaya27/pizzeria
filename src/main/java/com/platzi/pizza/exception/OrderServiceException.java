package com.platzi.pizza.exception;

/**
 * Exception thrown when an error occurs in OrderService layer.
 *
 * This is a generic exception for service-layer failures that should be
 * wrapped and converted to HTTP responses at Controller level.
 */
public class OrderServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs OrderServiceException with message.
     *
     * @param message the detail message
     */
    public OrderServiceException(String message) {
        super(message);
    }

    /**
     * Constructs OrderServiceException with message and cause.
     *
     * @param message the detail message
     * @param cause the cause of the exception
     */
    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs OrderServiceException with cause only.
     *
     * @param cause the cause of the exception
     */
    public OrderServiceException(Throwable cause) {
        super(cause);
    }
}


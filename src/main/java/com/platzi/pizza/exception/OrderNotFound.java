package com.platzi.pizza.exception;

public class OrderNotFound extends RuntimeException {
    public OrderNotFound(Integer id) {
        super("Order not found with id: " + id);
    }
}

package com.platzi.pizza.exception;

public class PizzaNotFound extends RuntimeException {
    public PizzaNotFound(Integer id) {
        super("Pizza not found with id: " + id);
    }
}

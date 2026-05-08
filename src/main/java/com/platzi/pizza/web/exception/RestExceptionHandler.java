package com.platzi.pizza.web.exception;

import com.platzi.pizza.exception.OrderNotFound;
import com.platzi.pizza.exception.PizzaNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(PizzaNotFound.class)
    public ResponseEntity<Error> handleException(PizzaNotFound exception) {
        Error error = new Error("pizza-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgument(IllegalArgumentException ex){
        Error error = new Error("400", ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(OrderNotFound.class)
    public ResponseEntity<Error> handleOrderNotFound(OrderNotFound exception){
        Error error = new Error("order-not-found", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}

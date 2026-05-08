package com.platzi.pizza.domain.dto.order;

public record ResponseOrderItem(
        Integer idItem,
        Integer idOrder,
        Integer idPizza,
        Double price,
        Double quantity
) {
}

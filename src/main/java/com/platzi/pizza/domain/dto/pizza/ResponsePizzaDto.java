package com.platzi.pizza.domain.dto.pizza;

public record ResponsePizzaDto(
        Integer idPizza,
        String name,
        String description,
        Double price,
        Boolean vegan,
        Boolean vegetarian,
        Boolean available
) {
}

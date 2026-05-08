package com.platzi.pizza.domain.dto.pizza;

import jakarta.validation.constraints.Positive;

public record UpdatePizzaDto(
        String name,
        String description,
        @Positive(message = "El precio debe de ser mayor a 0.0")
        Double price,
        Boolean vegan,
        Boolean vegetarian
) {
}

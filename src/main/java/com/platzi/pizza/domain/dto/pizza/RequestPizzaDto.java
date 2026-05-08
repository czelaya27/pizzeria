package com.platzi.pizza.domain.dto.pizza;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RequestPizzaDto(
        @NotBlank(message = "El nombre es obligatorio")
        String name,

        String description,


        @NotNull(message = "El precio es obligatorio")
        @Positive(message = "El precio debe de ser mayor a 0.0")
        Double price,

        @NotNull(message = "El campo vegan es obligatorio")
        Boolean vegan,

        @NotNull(message = "El campo vegetariano es obligatorio")
        Boolean vegetarian,

        @NotNull(message = "El campo available es obligatorio")
        Boolean available
) {
}

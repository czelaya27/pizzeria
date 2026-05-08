package com.platzi.pizza.domain.dto.common;

import java.util.List;

public record PageResponseDto<T>(
        List<T> content,
        Integer page,
        Integer size,
        Long totalElements,
        Integer totalPages,
        Boolean last,
        SortResponseDto sort
) {
}

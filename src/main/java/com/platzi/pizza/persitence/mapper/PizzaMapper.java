package com.platzi.pizza.persitence.mapper;

import com.platzi.pizza.domain.dto.common.PageResponseDto;
import com.platzi.pizza.domain.dto.common.SortResponseDto;
import com.platzi.pizza.domain.dto.pizza.RequestPizzaDto;
import com.platzi.pizza.domain.dto.pizza.ResponsePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaDto;
import com.platzi.pizza.persitence.entity.PizzaEntity;
import org.mapstruct.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PizzaMapper {
    ResponsePizzaDto toDo(PizzaEntity pizza);
    List<ResponsePizzaDto> toDo(Iterable<PizzaEntity> pizza);

    @InheritInverseConfiguration
    PizzaEntity toEntity(RequestPizzaDto dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(UpdatePizzaDto updatePizzaDto, @MappingTarget PizzaEntity pizzaEntity);

    default PageResponseDto<ResponsePizzaDto> toPageResponseDto(Page<PizzaEntity> page) {
        return new PageResponseDto<>(
                toDo(page.getContent()),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isLast(),
                toSortResponseDto(page)
        );
    }

    default SortResponseDto toSortResponseDto(Page<PizzaEntity> page) {
        return page.getSort()
                .stream()
                .findFirst()
                .map(order -> new SortResponseDto(
                        order.getProperty(),
                        order.getDirection().name()
                ))
                .orElse(null);
    }
}

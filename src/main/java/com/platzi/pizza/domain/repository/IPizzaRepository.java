package com.platzi.pizza.domain.repository;

import com.platzi.pizza.domain.dto.common.PageResponseDto;
import com.platzi.pizza.domain.dto.pizza.RequestPizzaDto;
import com.platzi.pizza.domain.dto.pizza.ResponsePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaPriceDto;
import com.platzi.pizza.domain.enums.SortDirection;

import java.util.List;

public interface IPizzaRepository {
    PageResponseDto<ResponsePizzaDto> findAll(Integer page, Integer size, String sortBy, SortDirection sortDir);
    List<ResponsePizzaDto> findAllByAvailableTrueOrderByPrice();
    List<ResponsePizzaDto> findAllByAvailableTrueAndNameIgnoreCase(String name);
    List<ResponsePizzaDto> findAllByAvailableAndDescriptionContainingIgnoreCase(String description);
    ResponsePizzaDto findById(Integer id);
    ResponsePizzaDto save(RequestPizzaDto requestPizzaDto);
    ResponsePizzaDto update(Integer id, UpdatePizzaDto updatePizzaDto);
    ResponsePizzaDto delete(Integer id);
    List<ResponsePizzaDto> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(Double price);
    Boolean existsByIdPizza(Integer idPizza);
    void updatePizzaPrice(UpdatePizzaPriceDto updatePizzaPriceDto);
}

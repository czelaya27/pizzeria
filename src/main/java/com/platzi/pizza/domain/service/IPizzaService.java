package com.platzi.pizza.domain.service;

import com.platzi.pizza.domain.dto.common.PageResponseDto;
import com.platzi.pizza.domain.dto.pizza.RequestPizzaDto;
import com.platzi.pizza.domain.dto.pizza.ResponsePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaPriceDto;
import com.platzi.pizza.domain.enums.SortDirection;

import java.util.List;

public interface IPizzaService {
    PageResponseDto<ResponsePizzaDto> getAll(Integer page, Integer size, String sortBy, SortDirection sortDir);
    List<ResponsePizzaDto> findAllByAvailableTrueOrderByPrice();
    List<ResponsePizzaDto> findAllByAvailableTrueAndNameIgnoreCase(String name);
    List<ResponsePizzaDto> findAllByAvailableAndDescriptionContainingIgnoreCase(String description);
    ResponsePizzaDto getById(Integer id);
    ResponsePizzaDto create(RequestPizzaDto requestPizzaDto);
    ResponsePizzaDto update(Integer id, UpdatePizzaDto updatePizzaDto);
    ResponsePizzaDto deleteById(Integer id);
    List<ResponsePizzaDto> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(Double price);
    void updatePizzaPrice(UpdatePizzaPriceDto updatePizzaPriceDto);
}

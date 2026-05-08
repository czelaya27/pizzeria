package com.platzi.pizza.domain.service.Impl;

import com.platzi.pizza.domain.dto.common.PageResponseDto;
import com.platzi.pizza.domain.dto.pizza.RequestPizzaDto;
import com.platzi.pizza.domain.dto.pizza.ResponsePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaPriceDto;
import com.platzi.pizza.domain.enums.SortDirection;
import com.platzi.pizza.domain.repository.IPizzaRepository;
import com.platzi.pizza.domain.service.IPizzaService;
import com.platzi.pizza.exception.PizzaNotFound;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService implements IPizzaService {
    private final IPizzaRepository pizzaRepository;

    public PizzaService(IPizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Override
    public PageResponseDto<ResponsePizzaDto> getAll(Integer page, Integer size, String sortBy, SortDirection sortDir){
        return this.pizzaRepository.findAll(page, size, sortBy, sortDir);
    }

    @Override
    public List<ResponsePizzaDto> findAllByAvailableTrueOrderByPrice() {
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    @Override
    public List<ResponsePizzaDto> findAllByAvailableTrueAndNameIgnoreCase(String name) {
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

    @Override
    public List<ResponsePizzaDto> findAllByAvailableAndDescriptionContainingIgnoreCase(String description) {
        return this.pizzaRepository.findAllByAvailableAndDescriptionContainingIgnoreCase(description);
    }


    @Override
    public ResponsePizzaDto getById(Integer id){
        return this.pizzaRepository.findById(id);
    }


    @Override
    public ResponsePizzaDto create(RequestPizzaDto requestPizzaDto){
        return this.pizzaRepository.save(requestPizzaDto);
    }

    @Override
    public ResponsePizzaDto update(Integer id, UpdatePizzaDto updatePizzaDto) {
        return this.pizzaRepository.update(id, updatePizzaDto);
    }

    @Override
    public ResponsePizzaDto deleteById(Integer id) {
        return this.pizzaRepository.delete(id);
    }

    @Override
    public List<ResponsePizzaDto> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(Double price) {
        return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price);
    }

    @Override
    @Transactional
    public void updatePizzaPrice(UpdatePizzaPriceDto updatePizzaPriceDto) {
        boolean existsPizza = this.pizzaRepository.existsByIdPizza(updatePizzaPriceDto.idPizza());

        if (!existsPizza) {
            throw new PizzaNotFound(updatePizzaPriceDto.idPizza());
        }

        this.pizzaRepository.updatePizzaPrice(updatePizzaPriceDto);
    }
}

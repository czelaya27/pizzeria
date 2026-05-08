package com.platzi.pizza.persitence;

import com.platzi.pizza.domain.dto.common.PageResponseDto;
import com.platzi.pizza.domain.dto.pizza.RequestPizzaDto;
import com.platzi.pizza.domain.dto.pizza.ResponsePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaPriceDto;
import com.platzi.pizza.domain.enums.SortDirection;
import com.platzi.pizza.domain.repository.IPizzaRepository;
import com.platzi.pizza.exception.PizzaNotFound;
import com.platzi.pizza.persitence.entity.PizzaEntity;
import com.platzi.pizza.persitence.mapper.PizzaMapper;
import com.platzi.pizza.persitence.repository.PizzaPagSortRepository;
import com.platzi.pizza.persitence.repository.PizzaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaEntityRepository implements IPizzaRepository {

    private final PizzaRepository pizzaRepository;
    private final PizzaPagSortRepository pizzaPagSortRepository;
    private final PizzaMapper pizzaMapper;

    public PizzaEntityRepository(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository, PizzaMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaPagSortRepository = pizzaPagSortRepository;
        this.pizzaMapper = pizzaMapper;
    }

    @Override
    public PageResponseDto<ResponsePizzaDto> findAll(Integer page, Integer size, String sortBy, SortDirection sortDir) {
        int safePage = page == null || page < 0 ? 0 : page;
        int safeSize = size == null || size <= 0 ? 10 : size;
        String safeSortBy = sortBy == null || sortBy.isBlank() ? "idPizza" : sortBy;

        Sort.Direction direction = sortDir == null
                ? Sort.Direction.ASC
                : Sort.Direction.fromString(sortDir.name());

        Sort sort = Sort.by(direction, safeSortBy);

        Pageable pageable = PageRequest.of(safePage, safeSize, sort);
        Page<PizzaEntity> pizzaPage = this.pizzaPagSortRepository.findAllByAvailableTrue(pageable);
        return this.pizzaMapper.toPageResponseDto(pizzaPage);
    }


    @Override
    public List<ResponsePizzaDto> findAllByAvailableTrueOrderByPrice() {
        return this.pizzaMapper.toDo(this.pizzaRepository.findAllByAvailableTrueOrderByPrice());
    }

    @Override
    public List<ResponsePizzaDto> findAllByAvailableTrueAndNameIgnoreCase(String name) {
        return this.pizzaMapper.toDo(this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name));
    }

    @Override
    public List<ResponsePizzaDto> findAllByAvailableAndDescriptionContainingIgnoreCase(String description) {
        return this.pizzaMapper.toDo(this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(description));
    }

    @Override
    public ResponsePizzaDto findById(Integer id) {
        return this.pizzaMapper.toDo(this.pizzaRepository.findById(id).orElseThrow(() -> new PizzaNotFound(id)));
    }

    @Override
    public ResponsePizzaDto save(RequestPizzaDto requestPizzaDto) {
        PizzaEntity pizzaEntity = this.pizzaMapper.toEntity(requestPizzaDto);
        return this.pizzaMapper.toDo(this.pizzaRepository.save(pizzaEntity));
    }

    @Override
    public ResponsePizzaDto update(Integer id, UpdatePizzaDto updatePizzaDto) {
        PizzaEntity pizzaEntity = this.pizzaRepository.findById(id).orElseThrow(() -> new PizzaNotFound(id));
        if (updatePizzaDto.name() != null && updatePizzaDto.name().isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        this.pizzaMapper.updateEntityFromDto(updatePizzaDto, pizzaEntity);
        return  this.pizzaMapper.toDo(this.pizzaRepository.save(pizzaEntity));
    }

    @Override
    public ResponsePizzaDto delete(Integer id) {
        PizzaEntity pizzaEntity = this.pizzaRepository.findByIdPizzaAndAvailableTrue(id).orElseThrow(
                () -> new IllegalArgumentException("La pizza no existe o ya ha sido eliminada")
        );
        pizzaEntity.setAvailable(false);
        return this.pizzaMapper.toDo(this.pizzaRepository.save(pizzaEntity));
    }

    @Override
    public List<ResponsePizzaDto> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(Double price) {
        return this.pizzaMapper.toDo(this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price));
    }

    @Override
    public Boolean existsByIdPizza(Integer idPizza) {
        return this.pizzaRepository.existsByIdPizza(idPizza);
    }

    @Override
    public void updatePizzaPrice(UpdatePizzaPriceDto updatePizzaPriceDto) {
        this.pizzaRepository.updatePizzaPrice(updatePizzaPriceDto);
    }
}

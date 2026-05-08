package com.platzi.pizza.web.controller;

import com.platzi.pizza.domain.dto.common.PageResponseDto;
import com.platzi.pizza.domain.dto.pizza.RequestPizzaDto;
import com.platzi.pizza.domain.dto.pizza.ResponsePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaDto;
import com.platzi.pizza.domain.dto.pizza.UpdatePizzaPriceDto;
import com.platzi.pizza.domain.enums.SortDirection;
import com.platzi.pizza.domain.service.IPizzaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pizzas")
@Tag(name = "Pizzas")
public class PizzaController {

    private final IPizzaService pizzaService;

    @Autowired
    public PizzaController(IPizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping()
    public ResponseEntity<PageResponseDto<ResponsePizzaDto>> getAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") SortDirection sortDir
    ){
        return ResponseEntity.ok(this.pizzaService.getAll(page, size, sortBy, sortDir));
    }

    @GetMapping("/available")
    public ResponseEntity<List<ResponsePizzaDto>> getAllAvailable(){
        return ResponseEntity.ok(this.pizzaService.findAllByAvailableTrueOrderByPrice());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<ResponsePizzaDto>> getName(@PathVariable String name){
        return ResponseEntity.ok(this.pizzaService.findAllByAvailableTrueAndNameIgnoreCase(name));
    }

    @GetMapping("description/{description}")
    public ResponseEntity<List<ResponsePizzaDto>> getByDescription(@PathVariable String description){
        return ResponseEntity.ok(this.pizzaService.findAllByAvailableAndDescriptionContainingIgnoreCase(description));
    }

    @GetMapping("top/{price}")
    public ResponseEntity<List<ResponsePizzaDto>> getTop(@PathVariable Double price){
        return ResponseEntity.ok(this.pizzaService.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(price));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponsePizzaDto> getById(@PathVariable int id){
        return ResponseEntity.ok(this.pizzaService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<ResponsePizzaDto> save(@RequestBody RequestPizzaDto requestPizzaDto){
        return ResponseEntity.ok(pizzaService.create(requestPizzaDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponsePizzaDto> update(@PathVariable int id, @RequestBody UpdatePizzaDto updatePizzaDto){
        return ResponseEntity.ok(this.pizzaService.update(id, updatePizzaDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponsePizzaDto> delete(@PathVariable int id){
        return ResponseEntity.ok(this.pizzaService.deleteById(id));
    }

    @PutMapping("/price")
    public ResponseEntity<Void> updatePricePizza(@RequestBody UpdatePizzaPriceDto updatePizzaPriceDto){
        this.pizzaService.updatePizzaPrice(updatePizzaPriceDto);
        return ResponseEntity.ok().build();

    }

}

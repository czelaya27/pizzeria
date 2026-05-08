package com.platzi.pizza.persitence.repository;

import com.platzi.pizza.domain.dto.pizza.UpdatePizzaPriceDto;
import com.platzi.pizza.persitence.entity.PizzaEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {
    Optional<PizzaEntity> findByIdPizzaAndAvailableTrue(Integer idPizza);
    List<PizzaEntity> findAllByAvailableTrueOrderByPrice();
    List<PizzaEntity> findAllByAvailableTrueAndNameIgnoreCase(String name);
    List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String description);
    List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceAsc(Double price);
    Boolean existsByIdPizza(Integer idPizza);

    @Query(value = """
            UPDATE pizza
            SET price = :#{#newPizzaPrice.price()}
            WHERE id_pizza = :#{#newPizzaPrice.idPizza()}
            """,
            nativeQuery = true)
    @Modifying
    void updatePizzaPrice(@Param("newPizzaPrice")UpdatePizzaPriceDto newPizzaPrice);
}

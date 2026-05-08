package com.platzi.pizza.persitence.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class OrderItemId implements Serializable {
    @Column(name = "id_order")
    private Integer idOrder;
    @Column(name = "id_item")
    private Integer idItem;
}
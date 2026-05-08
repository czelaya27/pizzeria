package com.platzi.pizza.persitence.mapper;

import com.platzi.pizza.domain.dto.order.ResponseOrderItem;
import com.platzi.pizza.persitence.entity.OrderItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    ResponseOrderItem toDo(OrderItemEntity orderItemEntity);
}

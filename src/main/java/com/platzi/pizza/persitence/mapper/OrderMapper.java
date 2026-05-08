package com.platzi.pizza.persitence.mapper;

import com.platzi.pizza.domain.dto.order.ResponseOrderDto;
import com.platzi.pizza.domain.dto.order.ResponseOrderItem;
import com.platzi.pizza.persitence.entity.OrderEntity;
import com.platzi.pizza.persitence.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    ResponseOrderDto toDto(OrderEntity order);
    List<ResponseOrderDto> toDto(Iterable<OrderEntity> order);

    @Mapping(target = "idItem", source = "id.idItem")
    @Mapping(target = "idOrder", source = "id.idOrder")
    ResponseOrderItem toOrderItemDto(OrderItemEntity orderItem);
}

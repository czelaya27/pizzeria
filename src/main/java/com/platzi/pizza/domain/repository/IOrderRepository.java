package com.platzi.pizza.domain.repository;

import com.platzi.pizza.domain.dto.order.ResponseOrderDto;
import com.platzi.pizza.persitence.projection.OrderSummary;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderRepository {
    List<ResponseOrderDto> findAll();
    ResponseOrderDto findById(Integer id);
    List<ResponseOrderDto> findAllByDateAfter(LocalDateTime date);
    List<ResponseOrderDto> findAllByMethodIn(List<String> methods);
    List<ResponseOrderDto> findCustomerOrders(String idCustomer);
    OrderSummary getOrderSummary(int idOrder);
}

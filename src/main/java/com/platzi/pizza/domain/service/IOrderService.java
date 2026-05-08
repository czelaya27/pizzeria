package com.platzi.pizza.domain.service;

import com.platzi.pizza.domain.dto.order.ResponseOrderDto;
import com.platzi.pizza.persitence.projection.OrderSummary;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderService {
    List<ResponseOrderDto> findAll();
    ResponseOrderDto findById(Integer id);
    List<ResponseOrderDto> findAllByDateAfter(LocalDateTime date);
    List<ResponseOrderDto> findAllByMethodIn();
    List<ResponseOrderDto> findCustomerOrders(String idCustomer);
    OrderSummary getOrderSummary(int idOrder);
}

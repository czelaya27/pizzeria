package com.platzi.pizza.domain.service.Impl;

import com.platzi.pizza.domain.dto.order.ResponseOrderDto;
import com.platzi.pizza.domain.repository.IOrderRepository;
import com.platzi.pizza.domain.service.IOrderService;
import com.platzi.pizza.persitence.projection.OrderSummary;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;

    public OrderService(IOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<ResponseOrderDto> findAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public ResponseOrderDto findById(Integer id) {
        return this.orderRepository.findById(id);
    }

    @Override
    public List<ResponseOrderDto> findAllByDateAfter(LocalDateTime date) {
        return this.orderRepository.findAllByDateAfter(date);
    }

    @Override
    public List<ResponseOrderDto> findAllByMethodIn() {
        String DELIVERY = "D";
        String CARRYOUT = "C";
        List<String> methods = Arrays.asList(DELIVERY, CARRYOUT);
        return this.orderRepository.findAllByMethodIn(methods);
    }

    @Override
    public List<ResponseOrderDto> findCustomerOrders(String idCustomer) {
        return this.orderRepository.findCustomerOrders(idCustomer);
    }

    @Override
    public OrderSummary getOrderSummary(int idOrder) {
        return this.orderRepository.getOrderSummary(idOrder);
    }
}

package com.platzi.pizza.persitence;

import com.platzi.pizza.domain.dto.order.ResponseOrderDto;
import com.platzi.pizza.domain.repository.IOrderRepository;
import com.platzi.pizza.exception.OrderNotFound;
import com.platzi.pizza.persitence.mapper.OrderMapper;
import com.platzi.pizza.persitence.projection.OrderSummary;
import com.platzi.pizza.persitence.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class OrderEntityRepository implements IOrderRepository {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderEntityRepository(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<ResponseOrderDto> findAll() {
        return this.orderMapper.toDto(this.orderRepository.findAll());
    }

    @Override
    public ResponseOrderDto findById(Integer id) {
        return this.orderMapper.toDto(this.orderRepository.findById(id).orElseThrow(() -> new OrderNotFound(id)));
    }

    @Override
    public List<ResponseOrderDto> findAllByDateAfter(LocalDateTime date) {
        return this.orderMapper.toDto(this.orderRepository.findAllByDateAfter(date));
    }

    @Override
    public List<ResponseOrderDto> findAllByMethodIn(List<String> methods) {
        return this.orderMapper.toDto(this.orderRepository.findAllByMethodIn(methods));
    }

    @Override
    public List<ResponseOrderDto> findCustomerOrders(String idCustomer) {
        return this.orderMapper.toDto(this.orderRepository.findCustomerOrders(idCustomer));
    }

    @Override
    public OrderSummary getOrderSummary(int idOrder) {
        return this.orderRepository.getSummary(idOrder);
    }
}

package com.platzi.pizza.web.controller;

import com.platzi.pizza.domain.dto.order.ResponseOrderDto;
import com.platzi.pizza.domain.service.IOrderService;
import com.platzi.pizza.persitence.projection.OrderSummary;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("order")
@Tag(name = "Ordenes")
public class OrderController {
    private final IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseOrderDto>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseOrderDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping("date/{date}")
    public ResponseEntity<List<ResponseOrderDto>> findByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {
        return ResponseEntity.ok(orderService.findAllByDateAfter(date));
    }

    @GetMapping("outside")
    public ResponseEntity<List<ResponseOrderDto>> findByMethodIn() {
        return ResponseEntity.ok(orderService.findAllByMethodIn());
    }

    @GetMapping("customer/{id}")
    public ResponseEntity<List<ResponseOrderDto>> findByCustomer(@PathVariable String id) {
        return ResponseEntity.ok(orderService.findCustomerOrders(id));
    }

    @GetMapping("summary/{id}")
    public ResponseEntity<OrderSummary> getOrderSummary(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getOrderSummary(id));
    }
}

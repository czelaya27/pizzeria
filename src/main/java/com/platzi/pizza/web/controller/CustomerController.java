package com.platzi.pizza.web.controller;

import com.platzi.pizza.domain.dto.customer.ResponseCustomerDto;
import com.platzi.pizza.domain.service.ICustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customer")
@Tag(name = "Clientes")
public class CustomerController {

    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{phone}")
    public ResponseEntity<ResponseCustomerDto> findByPhoneNumber(@PathVariable String phone){
        return ResponseEntity.ok(this.customerService.findByPhoneNumber(phone));
    }
}

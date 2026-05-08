package com.platzi.pizza.domain.dto.customer;

public record ResponseCustomerDto(
        String idCustomer,
        String name,
        String address,
        String phoneNumber,
        String email
) {
}

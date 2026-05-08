package com.platzi.pizza.domain.repository;

import com.platzi.pizza.domain.dto.customer.ResponseCustomerDto;
import com.platzi.pizza.persitence.entity.CustomerEntity;

public interface ICustomerRepository {
    ResponseCustomerDto findByPhoneNumber(String phoneNumber);
}

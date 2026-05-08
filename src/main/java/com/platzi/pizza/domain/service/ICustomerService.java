package com.platzi.pizza.domain.service;

import com.platzi.pizza.domain.dto.customer.ResponseCustomerDto;
import com.platzi.pizza.persitence.entity.CustomerEntity;

public interface ICustomerService {
    ResponseCustomerDto findByPhoneNumber(String phoneNumber);
}

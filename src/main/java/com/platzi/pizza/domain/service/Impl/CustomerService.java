package com.platzi.pizza.domain.service.Impl;

import com.platzi.pizza.domain.dto.customer.ResponseCustomerDto;
import com.platzi.pizza.domain.repository.ICustomerRepository;
import com.platzi.pizza.domain.service.ICustomerService;
import com.platzi.pizza.persitence.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository customerRepository;

    public CustomerService(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseCustomerDto findByPhoneNumber(String phoneNumber) {
        return this.customerRepository.findByPhoneNumber(phoneNumber);
    }
}

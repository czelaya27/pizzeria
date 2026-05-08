package com.platzi.pizza.persitence;

import com.platzi.pizza.domain.dto.customer.ResponseCustomerDto;
import com.platzi.pizza.domain.repository.ICustomerRepository;
import com.platzi.pizza.persitence.mapper.CustomerMapper;
import com.platzi.pizza.persitence.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerEntityRepository implements ICustomerRepository {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerEntityRepository(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public ResponseCustomerDto findByPhoneNumber(String phoneNumber) {
        return this.customerMapper.toDo(this.customerRepository.findByPhoneNumber(phoneNumber));
    }
}

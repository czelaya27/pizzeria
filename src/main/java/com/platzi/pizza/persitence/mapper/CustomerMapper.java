package com.platzi.pizza.persitence.mapper;

import com.platzi.pizza.domain.dto.customer.ResponseCustomerDto;
import com.platzi.pizza.persitence.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    ResponseCustomerDto toDo (CustomerEntity customerEntity);
    List<ResponseCustomerDto> todo(Iterable<CustomerEntity> customerEntity);

}

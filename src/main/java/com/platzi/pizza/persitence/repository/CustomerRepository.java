package com.platzi.pizza.persitence.repository;

import com.platzi.pizza.persitence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {

    /* JPQL */
    @Query("SELECT c FROM CustomerEntity c WHERE c.phoneNumber = :phoneNumber")
    CustomerEntity findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}

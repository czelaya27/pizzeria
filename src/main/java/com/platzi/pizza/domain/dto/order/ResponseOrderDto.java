package com.platzi.pizza.domain.dto.order;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseOrderDto(
        Integer idOrder,
        String idCustomer,
        /* Traer los datos del customer -> ResponseCustomerDto customer,*/
        String additionalNotes,
        LocalDateTime date,
        Double total,
        String method,
        List<ResponseOrderItem> orderItems
) {
}

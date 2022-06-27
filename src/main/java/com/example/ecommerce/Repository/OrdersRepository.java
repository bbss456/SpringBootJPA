package com.example.ecommerce.Repository;


import com.example.ecommerce.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrdersRepository {

    private final EntityManager em;

    //주문등록
    public Long save(Order order){
        em.persist(order);
       return order.getOid();
    }


}

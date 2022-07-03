package com.example.ecommerce.Repository;


import com.example.ecommerce.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    /**
     * 주문 저장
     * @param order
     */
    public void save(Order order){
        em.persist(order);
    }

}

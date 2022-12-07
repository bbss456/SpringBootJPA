package com.example.ecommerce.Repository;


import com.example.ecommerce.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    /**
     * 주문 저장
     * @param order
     */
    public Long save(Order order){
        em.persist(order);

        return order.getOid();
    }

    public List<Order> findAllWithItem(String member_id) {
        return em.createQuery(
                "select o from Order o" +
                        " join fetch o.member m" +
                        " join fetch o.delivery d" +
                        " join fetch o.Orderitmes oi" +
                        " join fetch oi.items " +
                        " where o.member.member_id = :member_id" ,Order.class)
                .setParameter("member_id", member_id)
                .getResultList();
    }

}
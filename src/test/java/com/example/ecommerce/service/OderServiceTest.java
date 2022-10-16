package com.example.ecommerce.service;

import com.example.ecommerce.Repository.OrdersRepository;
import com.example.ecommerce.domain.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class OderServiceTest {

    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OderService oderService;
    @PersistenceContext
    EntityManager em ;

    @Autowired
    ItemService itemService;

    @Test
    @Rollback(value = false)
    public void 주문등록() {
       Order order = new Order();
       Member member = createMember();
       order.setMember(member);
       order.setStatus(OrderStatus.ORDER);

       Delivery delivery = new Delivery();
       delivery.setStatus(DeliveryStatus.READY);
       delivery.setAddress(new Address("인천광역시", "간석동", "1106호"));

       Item item = itemService.findItemone(16L);

       OrderItem orderItem = new OrderItem();
       orderItem = orderItem.createOrderItem(item, 3L, 3);

       order = order.createOrder(member, delivery, orderItem);

       oderService.registrationorder(order);
   }

   public Member createMember() {
       Member member = new Member();
       member.setMember_id("test");
       member.setName("황현수");
       member.setEmail("bbss67117@gmail.com");
       member.setPwd("Passwd");
       member.setPhone("010-3078-1207");
       member.setRegdata(new Date());
       member.setAddress(new Address("인천 ", "간석동", "1106호"));
       em.persist(member);
       return member;
   }

}
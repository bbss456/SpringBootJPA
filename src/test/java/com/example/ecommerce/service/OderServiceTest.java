package com.example.ecommerce.service;

import com.example.ecommerce.Dto.ResponseItemWithInfoDTO;
import com.example.ecommerce.Repository.OrderRepository;
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
import java.util.List;
import java.util.stream.Collectors;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class OderServiceTest {

    @Autowired
    OrderRepository ordersRepository;
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

   @Test
   public void 아이템_찾기() {
       List<Order> orderList =  ordersRepository.findAllWithItem("admin");

       List<ResponseItemWithInfoDTO> responseItemWithInfoDTOList =orderList.stream().map(order ->
               new ResponseItemWithInfoDTO(order.getOrderitmes().get(0).getItems().getName(),
                       order.getOrderitmes().get(0).getCount(),
                       order.getOrderitmes().get(0).getOrderPrice(),
                       order.getDelivery().getStatus(),
                       order.getOrderdata()))
               .collect(Collectors.toList());

       for (ResponseItemWithInfoDTO responseItemWithInfoDTO : responseItemWithInfoDTOList) {
          System.out.println( responseItemWithInfoDTO.toString());
       }
   }
}
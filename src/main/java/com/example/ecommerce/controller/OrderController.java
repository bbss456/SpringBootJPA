package com.example.ecommerce.controller;

import com.example.ecommerce.Dto.OrdersaveDTO;
import com.example.ecommerce.domain.*;
import com.example.ecommerce.service.ItemService;
import com.example.ecommerce.service.MemberService;
import com.example.ecommerce.service.OderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final MemberService memberService;

    private final ItemService itemService;

    private final OderService oderService;

    private HttpHeaders header() {
        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json",Charset.forName("UTF-8")));
        return headers;
    }


    @PostMapping("/api/item/order")
    public ResponseEntity<Boolean>  saveOrderItem(@RequestBody OrdersaveDTO ordersaveDTO) {
        Order order = new Order();
        Member member = memberService.findOne("1");
        order.setMember(member);
        order.setStatus(OrderStatus.ORDER);

        Delivery delivery = new Delivery();
        delivery.setStatus(DeliveryStatus.READY);
        delivery.setAddress(new Address(ordersaveDTO.getCity(),ordersaveDTO.getStreet(), ordersaveDTO.getZipcode()));

        Item item = itemService.findItemone(16L);

        OrderItem orderItem = new OrderItem();
        orderItem = orderItem.createOrderItem(item, 3L, 3);

        order = order.createOrder(member, delivery, orderItem);

        oderService.registrationorder(order);

        return new ResponseEntity<>(true, this.header(), HttpStatus.OK);
    }
}

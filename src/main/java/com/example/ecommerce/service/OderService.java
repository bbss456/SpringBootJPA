package com.example.ecommerce.service;

import com.example.ecommerce.Repository.OrdersRepository;
import com.example.ecommerce.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class OderService {

    @Autowired
    private  final  OrdersRepository ordersRepository;

    public OderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    //주문등록
    @Transactional
    public Long registrationorder(Order order) {
        return ordersRepository.save(order);
    }
}

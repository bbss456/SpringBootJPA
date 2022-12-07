package com.example.ecommerce.service;

import com.example.ecommerce.Dto.ResponseItemWithInfoDTO;
import com.example.ecommerce.Repository.OrderRepository;
import com.example.ecommerce.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class OderService {

    @Autowired
    private  final OrderRepository ordersRepository;

    public OderService(OrderRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    //주문등록
    @Transactional
    public Long registrationorder(Order order) {
        return ordersRepository.save(order);
    }

    public List<ResponseItemWithInfoDTO> findOrderItem(String memberId) {
        List<Order> orderList =  ordersRepository.findAllWithItem(memberId);

        List<ResponseItemWithInfoDTO> responseItemWithInfoDTOList =orderList.stream().map(order ->
                new ResponseItemWithInfoDTO(order.getOrderitmes().get(0).getItems().getName(),
                        order.getOrderitmes().get(0).getCount(),
                        order.getOrderitmes().get(0).getOrderPrice(),
                        order.getDelivery().getStatus(),
                        order.getOrderdata()))
                .collect(Collectors.toList());

    return responseItemWithInfoDTOList;
    }
}

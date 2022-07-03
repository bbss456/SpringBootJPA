package com.example.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_itemid")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderOID")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemoid")
    private Item items;

    private Long orderPrice;
    private int count;

    //==생성 메서드==//
    public static OrderItem createOrderItem(Item item, Long orderPrice, int  count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItems(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);
        item.removeStock(count);
        return orderItem;
    }
    //==비즈니스 로직==//
    /** 주문 취소 */
    public void cancel() {
        getItems().addStock(count);
    }
    //==조회 로직==//
    /** 주문상품 전체 가격 조회 */
    public int getTotalPrice() {
        return (int) (getOrderPrice() * getCount());
    }


}

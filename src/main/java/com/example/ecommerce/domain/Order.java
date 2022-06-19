package com.example.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter

@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) //orderID
    @Column(name = "OrderOID")
    private Long oid;

    @ManyToOne(fetch = FetchType.LAZY)// JPA에서는 데이터를 조회할 때 즉시 로딩(EAGER)과 지연 로딩(LAZY) 두 가지 방식이 있다. 이 두 가지 방식을 간단하게 설명하면 즉시 로딩은 데이터를 조회할 때 연관된 데이터까지 한 번에 불러오는 것이고, 지연 로딩은 필요한 시점에 연관된 데이터를 불러오는 것이라고 할 수 있다.
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL) //상위 엔터티에서 하위 엔터티로 모든 작업을 전파
    private List<OrderItem> Orderitmes = new ArrayList<>();

    //오더에서 주문 쪽을 더 많이 보기 때문에 여기가 주인
    @OneToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Column
    private LocalDateTime orderdata ;

    private OrderStatus status; //주문 상태 ORDER,CANCLE

    //==연관관계 메서드==//
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }
    public void addOrderItem(OrderItem orderItem) {
        Orderitmes.add(orderItem);
        orderItem.setOrder(this);
    }
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

}

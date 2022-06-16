package com.example.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter

@Table(name = "orders")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long oid;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "item_id")
//    private List<Item> itmes = new ArrayList<>();
    private String item ;

    private String status;

    @CreatedDate
    @Generated(GenerationTime.INSERT)
    @Column
    private LocalDate orderdata ;

}

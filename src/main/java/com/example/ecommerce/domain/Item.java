package com.example.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Item {

 @Id @GeneratedValue
 @Column(name = "ItemOID")
 private Long  id;

 private String name;

 private int price ;

 @OneToMany(mappedBy = "items",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
 List<OrderItem> OrderItems = new ArrayList<>();

 private LocalDateTime DateTime; // 등록 날짜짜
}

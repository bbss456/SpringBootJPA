package com.example.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Item {

 @Id @GeneratedValue
 @Column(name = "itemoid")
 private Long  id;

 private String name;

 private int price ;

 private int ItemCount;
 @OneToMany(mappedBy = "items",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
 List<OrderItem> OrderItems = new ArrayList<>();

 @CreatedDate
 @Temporal(TemporalType.DATE)
 @Column
 private Date regdata ;
}

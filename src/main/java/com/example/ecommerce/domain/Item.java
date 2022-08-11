package com.example.ecommerce.domain;

import com.example.ecommerce.NotEnoughStockException;
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

 private String category ;

 private int price ;

 private String content ;

 private String imgpath ;


 private int ItemCount;
 @OneToMany(mappedBy = "items",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
 List<OrderItem> OrderItems = new ArrayList<>();

 @CreatedDate
 @Temporal(TemporalType.DATE)
 @Column
 private Date regdata ;



 //==비즈니스 로직==//
 public void addStock(int quantity) {
  this.ItemCount += quantity;
 }
 public void removeStock(int quantity) {
  int restStock = this.ItemCount - quantity;
  if (restStock < 0) {
   throw new NotEnoughStockException("need more stock");
  }
  this.ItemCount = restStock;
 }
}

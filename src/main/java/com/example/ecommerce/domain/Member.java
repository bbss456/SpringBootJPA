package com.example.ecommerce.domain;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter @Setter

public class Member {

    @Id
    private  String member_id;

    private  String name;

    private  String pwd;

    private  String phone;

    private  String email;

    @Embedded
    private  Address address;

    @OneToMany(mappedBy="member",fetch = FetchType.LAZY ,cascade = CascadeType.ALL)//연결관계에 주인이 아닌 것을 나타냄. 여기서 값 변경되면 order에서 변경 안됨.
    List<Order> orders = new ArrayList<>();

    @CreatedDate
    @Generated(GenerationTime.INSERT)
    @Column
    private LocalDate regdata ;

}

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

public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String member_id;

    private  String name;

    private  String pwd;

    private String Rregistration_number ;

    private  String phone;

    private  String email;

    private  String region;

    //List<Orders> order = new ArrayList<>();
    @CreatedDate
    @Generated(GenerationTime.INSERT)
    @Column
    private LocalDate regdata ;

}

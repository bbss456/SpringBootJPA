package com.example.ecommerce.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Entity
@Getter @Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private  String id;

    private  String name;

    private  String pwd;

    private  String sex;;

    private  String phone;

    private  String email;

    private  String region;

    //List<Orders> order = new ArrayList<>();

    @CreatedDate
    private LocalDate regdata ;

}

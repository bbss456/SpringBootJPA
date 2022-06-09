package com.example.shop;

import org.springframework.boot.SpringApplication;

public class test {

    public static void main(String[] args){
        Hello1 hello = new Hello1();
        hello.setData("asd");
        System.out.println(hello.getData());
        SpringApplication.run(ShopApplication.class,args);

    }
}

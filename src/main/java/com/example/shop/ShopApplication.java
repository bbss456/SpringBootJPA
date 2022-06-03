package com.example.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args){
		Hello1 hello = new Hello1();
		hello.setData("asd");
		System.out.println(hello.getData());
		SpringApplication.run(ShopApplication.class,args);
	}
}

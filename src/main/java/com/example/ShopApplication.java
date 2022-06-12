package com.example;

import com.example.shop.Hello1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopApplication {

	public static void main(String[] args){
		Hello1 hello = new Hello1();
		SpringApplication.run(ShopApplication.class,args);

	}

}

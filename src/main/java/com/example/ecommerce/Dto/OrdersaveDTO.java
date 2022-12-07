package com.example.ecommerce.Dto;

import lombok.Data;

@Data
public class OrdersaveDTO {
    private String memberId;
    private Long itemId;
    private Long itemPrice;
    private int itemCount;
    private String city;
    private String street;
    private String zipcode;
}

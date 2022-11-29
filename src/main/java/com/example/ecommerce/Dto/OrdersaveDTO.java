package com.example.ecommerce.Dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrdersaveDTO {

    private String itemId;
    private String city;
    private String street;
    private String zipcode;



}

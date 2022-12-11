package com.example.ecommerce.Dto;

import com.example.ecommerce.domain.DeliveryStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseItemWithInfoDTO {
    @JsonIgnore
    public String itemName;
    public int count;
    public Long price;
    public DeliveryStatus deliveryStatus;
    public LocalDateTime orderDate;

    public ResponseItemWithInfoDTO(String itemName,int count ,Long price, DeliveryStatus deliveryStatus, LocalDateTime orderDate) {
        this.itemName = itemName;
        this.count = count;
        this.price = price;
        this.deliveryStatus = deliveryStatus;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "ResponseItemWithInfoDTO{" +
                "itemName='" + itemName + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", deliveryStatus=" + deliveryStatus +
                '}';
    }
}

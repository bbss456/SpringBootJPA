package com.example.ecommerce.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter @Getter
public class Delivery {

    @Id @GeneratedValue
    @Column(name ="delivery_id")
    private Long id;

    @OneToOne(mappedBy ="delivery",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Order order;

    @Embedded
    private  Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;
}

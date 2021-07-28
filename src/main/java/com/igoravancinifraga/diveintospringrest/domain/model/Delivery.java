package com.igoravancinifraga.diveintospringrest.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //one customer to many deliveries
//    @JoinColumn(name = "customer_id") //if I wanna specify a custom join column name, this property is used
    private Customer customer;

    @Embedded //this data will be inside the Delivery table but is represented in a different class
    private Recipient recipient;

    private BigDecimal fee;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING) //we wanna save the value of the enum in the column
    private StatusDelivery status;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime orderDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime conclusionDate;
}

package com.igoravancinifraga.diveintospringrest.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.igoravancinifraga.diveintospringrest.domain.ValidationGroups;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
//    @Valid
//    @ConvertGroup(from = Default.class, to = ValidationGroups.CustomerId.class) //specific group to validate only this field from Customer
    @ManyToOne //one customer to many deliveries
//    @JoinColumn(name = "customer_id") //if I wanna specify a custom join column name, this property is used
    private Customer customer;

    @NotNull
    @Valid
    @Embedded //this data will be inside the Delivery table but is represented in a different class
    private Recipient recipient;

    @NotNull
    private BigDecimal fee;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Enumerated(EnumType.STRING) //we wanna save the value of the enum in the column
    private StatusDelivery status;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime orderDate;

//    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private OffsetDateTime conclusionDate;
}

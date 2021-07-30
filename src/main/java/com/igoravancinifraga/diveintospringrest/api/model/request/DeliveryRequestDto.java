package com.igoravancinifraga.diveintospringrest.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class DeliveryRequestDto {

    @Valid
    @NotNull
    private CustomerIdRequestDto customer;

    @Valid
    @NotNull
    private RecipientRequestDto recipient;

    @NotNull
    private BigDecimal fee;
}

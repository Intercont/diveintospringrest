package com.igoravancinifraga.diveintospringrest.api.model;

import com.igoravancinifraga.diveintospringrest.domain.model.StatusDelivery;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
public class DeliveryResponseDto {

    private Long id;
    private String customerName;
    private RecipientResponseDto recipient;
    private BigDecimal fee;
    private StatusDelivery status;
    private OffsetDateTime orderDate;
    private OffsetDateTime conclusionDate;
}

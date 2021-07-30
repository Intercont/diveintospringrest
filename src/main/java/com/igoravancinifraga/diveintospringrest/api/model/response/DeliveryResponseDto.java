package com.igoravancinifraga.diveintospringrest.api.model.response;

import com.igoravancinifraga.diveintospringrest.domain.model.StatusDelivery;
import lombok.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryResponseDto {

    private Long id;
    private CustomerBriefingResponseDto customer;
    private RecipientResponseDto recipient;
    private BigDecimal fee;
    private StatusDelivery status;
    private OffsetDateTime orderDate;
    private OffsetDateTime conclusionDate;
}

package com.igoravancinifraga.diveintospringrest.api.model.response;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class EventResponseDto {

    private Long id;
    private String description;
    private OffsetDateTime eventDateTime;
}

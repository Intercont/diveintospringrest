package com.igoravancinifraga.diveintospringrest.api.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class RecipientResponseDto {
    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;
}

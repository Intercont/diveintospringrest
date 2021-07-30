package com.igoravancinifraga.diveintospringrest.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class RecipientRequestDto {

    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    @NotBlank
    private String complement;

    @NotBlank
    private String district;
}

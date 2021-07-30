package com.igoravancinifraga.diveintospringrest.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CustomerIdRequestDto {

    @NotNull
    private Long id;
}

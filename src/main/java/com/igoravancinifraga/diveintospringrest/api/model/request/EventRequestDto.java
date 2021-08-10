package com.igoravancinifraga.diveintospringrest.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class EventRequestDto {

    @NotBlank
    private String description;

}

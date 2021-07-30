package com.igoravancinifraga.diveintospringrest.api.model.response;

import lombok.*;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipientResponseDto {
    private String name;
    private String street;
    private String number;
    private String complement;
    private String district;
}

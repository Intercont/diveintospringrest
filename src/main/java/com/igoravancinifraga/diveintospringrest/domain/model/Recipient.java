package com.igoravancinifraga.diveintospringrest.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Getter @Setter
@Embeddable //specify that this class can be Embedded by other entities
public class Recipient {

    @NotBlank
    @Column(name = "recipient_name") //for the sake of legibility, I'm specifying what this name is, since this will be embedded in the Delivery Table
    private String name;

    @NotBlank
    @Column(name = "recipient_street")
    private String street;

    @NotBlank
    @Column(name = "recipient_number")
    private String number;

    @NotBlank
    @Column(name = "recipient_complement")
    private String complement;

    @NotBlank
    @Column(name = "recipient_district")
    private String district;
}

package com.igoravancinifraga.diveintospringrest.domain.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter @Setter
@Embeddable //specify that this class can be Embedded by other entities
public class Recipient {

    @Column(name = "recipient_name") //for the sake of legibility, I'm specifying what this name is, since this will be embedded in the Delivery Table
    private String name;

    @Column(name = "recipient_street")
    private String street;

    @Column(name = "recipient_number")
    private String number;

    @Column(name = "recipient_complement")
    private String complement;

    @Column(name = "recipient_district")
    private String district;
}

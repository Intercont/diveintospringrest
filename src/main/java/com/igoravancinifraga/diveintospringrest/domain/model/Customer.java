package com.igoravancinifraga.diveintospringrest.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Customer {

    @Id
    @EqualsAndHashCode.Include //specify that only this field will be used to EqualsAndHashCode with the option onlyExplicitlyIncluded = true
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Column(name = "phone")
    private String telephone;

}

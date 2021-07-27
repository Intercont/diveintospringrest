package com.igoravancinifraga.diveintospringrest.domain.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Customer {

    @EqualsAndHashCode.Include //specify that only this field will be used to EqualsAndHashCode with the option onlyExplicitlyIncluded = true
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank //validates if this is empty or null
    @Size(max = 60)
    private String name;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "phone")
    private String telephone;

}

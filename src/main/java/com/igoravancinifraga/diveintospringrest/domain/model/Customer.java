package com.igoravancinifraga.diveintospringrest.domain.model;

import com.igoravancinifraga.diveintospringrest.domain.ValidationGroups;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Customer {

    @NotNull(groups = ValidationGroups.CustomerId.class) //will be validated only when the convertion group called is the CustomerId
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

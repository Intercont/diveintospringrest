package com.igoravancinifraga.diveintospringrest.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Event {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //each event belows to a single delivery. A delivery can contain many events
    private Delivery delivery;

    private String description;
    private OffsetDateTime eventDateTime;
}

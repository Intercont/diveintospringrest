package com.igoravancinifraga.diveintospringrest.api.controller;

import com.igoravancinifraga.diveintospringrest.api.model.DeliveryResponseDto;
import com.igoravancinifraga.diveintospringrest.api.model.RecipientResponseDto;
import com.igoravancinifraga.diveintospringrest.domain.model.Delivery;
import com.igoravancinifraga.diveintospringrest.domain.repository.DeliveryRepository;
import com.igoravancinifraga.diveintospringrest.domain.service.RequestDeliveryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private RequestDeliveryService requestDeliveryService;
    private DeliveryRepository deliveryRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Delivery request(@Valid @RequestBody Delivery delivery) {
        return requestDeliveryService.request(delivery);
    }

    @GetMapping
    public List<Delivery> list() {
        return deliveryRepository.findAll();
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryResponseDto> find(@PathVariable Long deliveryId) {

        return deliveryRepository.findById(deliveryId)
                .map(delivery -> {
                    DeliveryResponseDto build = DeliveryResponseDto.builder()
                            .id(delivery.getId())
                            .customerName(delivery.getCustomer().getName())
                            .recipient(RecipientResponseDto.builder()
                                    .name(delivery.getRecipient().getName())
                                    .street(delivery.getRecipient().getStreet())
                                    .number(delivery.getRecipient().getNumber())
                                    .complement(delivery.getRecipient().getComplement())
                                    .district(delivery.getRecipient().getDistrict())
                                    .build())
                            .fee(delivery.getFee())
                            .status(delivery.getStatus())
                            .orderDate(delivery.getOrderDate())
                            .conclusionDate(delivery.getConclusionDate())
                            .build();

                    return ResponseEntity.ok(build);

                }) //return OK with the Optional content as a response
                .orElse(ResponseEntity.notFound().build());

    }
}

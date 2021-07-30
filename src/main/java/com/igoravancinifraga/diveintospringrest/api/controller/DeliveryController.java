package com.igoravancinifraga.diveintospringrest.api.controller;

import com.igoravancinifraga.diveintospringrest.api.model.request.DeliveryRequestDto;
import com.igoravancinifraga.diveintospringrest.api.model.response.DeliveryResponseDto;
import com.igoravancinifraga.diveintospringrest.domain.model.Delivery;
import com.igoravancinifraga.diveintospringrest.domain.repository.DeliveryRepository;
import com.igoravancinifraga.diveintospringrest.domain.service.RequestDeliveryService;
import com.igoravancinifraga.diveintospringrest.mapper.DeliveryMapper;
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
    private DeliveryMapper deliveryMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryResponseDto request(@Valid @RequestBody DeliveryRequestDto deliveryRequestDto) {
        Delivery newDelivery = deliveryMapper.toEntity(deliveryRequestDto);
        Delivery requestedDelivery = requestDeliveryService.request(newDelivery);
        return deliveryMapper.toModel(requestedDelivery);
    }

    @GetMapping
    public List<DeliveryResponseDto> list() {
        return deliveryMapper.toCollectionModel(deliveryRepository.findAll());
    }

    @GetMapping("/{deliveryId}")
    public ResponseEntity<DeliveryResponseDto> find(@PathVariable Long deliveryId) {
        return deliveryRepository.findById(deliveryId)
                .map(delivery -> ResponseEntity.ok(deliveryMapper.toModel(delivery))) //return OK with the Optional content as a response
                .orElse(ResponseEntity.notFound().build());
    }
}

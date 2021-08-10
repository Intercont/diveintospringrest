package com.igoravancinifraga.diveintospringrest.api.controller;

import com.igoravancinifraga.diveintospringrest.api.model.request.EventRequestDto;
import com.igoravancinifraga.diveintospringrest.api.model.response.EventResponseDto;
import com.igoravancinifraga.diveintospringrest.domain.model.Delivery;
import com.igoravancinifraga.diveintospringrest.domain.model.Event;
import com.igoravancinifraga.diveintospringrest.domain.service.FindDeliveryService;
import com.igoravancinifraga.diveintospringrest.domain.service.RegisterEventService;
import com.igoravancinifraga.diveintospringrest.mapper.EventMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/events")
public class EventController {

    private RegisterEventService registerEventService;
    private EventMapper eventMapper;
    private FindDeliveryService findDeliveryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EventResponseDto register(@PathVariable Long deliveryId,
                                     @Valid @RequestBody EventRequestDto eventRequestDto) {
        Event registeredEvent = registerEventService.register(deliveryId, eventRequestDto.getDescription());

        return eventMapper.toResponseModel(registeredEvent);
    }

    @GetMapping
    public List<EventResponseDto> list(@PathVariable Long deliveryId) {
        Delivery delivery = findDeliveryService.find(deliveryId);

        return eventMapper.toCollectionResponseModel(delivery.getEvents());
    }
}

package com.igoravancinifraga.diveintospringrest.domain.service;

import com.igoravancinifraga.diveintospringrest.domain.model.Delivery;
import com.igoravancinifraga.diveintospringrest.domain.model.Event;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegisterEventService {

    private FindDeliveryService findDeliveryService;

    @Transactional
    public Event register(Long id, String description) {
        Delivery delivery = findDeliveryService.find(id);

        return delivery.addEvent(description);
    }

}

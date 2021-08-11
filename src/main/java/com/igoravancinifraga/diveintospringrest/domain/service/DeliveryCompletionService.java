package com.igoravancinifraga.diveintospringrest.domain.service;

import com.igoravancinifraga.diveintospringrest.domain.model.Delivery;
import com.igoravancinifraga.diveintospringrest.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class DeliveryCompletionService {

    private FindDeliveryService findDeliveryService;
    private DeliveryRepository deliveryRepository;

    @Transactional
    public void complete(Long deliveryId) {
        Delivery delivery = findDeliveryService.find(deliveryId);

        delivery.complete();

        deliveryRepository.save(delivery);
    }
}

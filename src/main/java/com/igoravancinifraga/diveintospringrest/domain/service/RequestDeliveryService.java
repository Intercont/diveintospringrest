package com.igoravancinifraga.diveintospringrest.domain.service;

import com.igoravancinifraga.diveintospringrest.domain.model.Customer;
import com.igoravancinifraga.diveintospringrest.domain.model.Delivery;
import com.igoravancinifraga.diveintospringrest.domain.model.StatusDelivery;
import com.igoravancinifraga.diveintospringrest.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class RequestDeliveryService {

    private DeliveryRepository deliveryRepository;
    private CustomerCatalogService customerCatalogService;

    @Transactional
    public Delivery request(Delivery delivery) {
        Customer customer = customerCatalogService.findById(delivery.getCustomer().getId());

        delivery.setCustomer(customer);
        delivery.setStatus(StatusDelivery.PENDING);
        delivery.setOrderDate(OffsetDateTime.now());

        return deliveryRepository.save(delivery);
    }
}

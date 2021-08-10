package com.igoravancinifraga.diveintospringrest.domain.service;

import com.igoravancinifraga.diveintospringrest.domain.exception.BusinessException;
import com.igoravancinifraga.diveintospringrest.domain.model.Delivery;
import com.igoravancinifraga.diveintospringrest.domain.repository.DeliveryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindDeliveryService {

    private DeliveryRepository deliveryRepository;

    public Delivery find(Long id) {
        return deliveryRepository.findById(id).orElseThrow(() -> new BusinessException("Delivery not found"));
    }
}

package com.igoravancinifraga.diveintospringrest.mapper;

import com.igoravancinifraga.diveintospringrest.api.model.request.DeliveryRequestDto;
import com.igoravancinifraga.diveintospringrest.api.model.response.DeliveryResponseDto;
import com.igoravancinifraga.diveintospringrest.domain.model.Delivery;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DeliveryMapper {

    private ModelMapper modelMapper;

    public DeliveryResponseDto toResponseModel(Delivery delivery) {
        return modelMapper.map(delivery, DeliveryResponseDto.class);
    }

    public List<DeliveryResponseDto> toCollectionResponseModel(List<Delivery> deliveryList) {
        //we cannot convert it directly cause the convertion will be ignored and the Entity will be passed
        //so, in this case, let's convert through mapping
        return deliveryList.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }

    public Delivery toEntity(DeliveryRequestDto deliveryRequestDto) {
        return modelMapper.map(deliveryRequestDto, Delivery.class);
    }
}

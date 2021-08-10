package com.igoravancinifraga.diveintospringrest.mapper;

import com.igoravancinifraga.diveintospringrest.api.model.response.EventResponseDto;
import com.igoravancinifraga.diveintospringrest.domain.model.Event;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EventMapper {

    private ModelMapper modelMapper;

    public EventResponseDto toResponseModel(Event event) {
        return modelMapper.map(event, EventResponseDto.class);
    }

    public List<EventResponseDto> toCollectionResponseModel(List<Event> eventList) {
        return eventList.stream()
                .map(this::toResponseModel)
                .collect(Collectors.toList());
    }

}

package com.igoravancinifraga.diveintospringrest.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@Builder
public class CustomerException {
    private Integer status;
    private LocalDateTime dateTime;
    private String title;
    private List<Fields> fields;

    @AllArgsConstructor
    @Getter
    public static class Fields {
        private String name;
        private String message;
    }

}
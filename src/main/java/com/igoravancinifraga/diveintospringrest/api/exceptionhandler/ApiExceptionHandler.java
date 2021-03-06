package com.igoravancinifraga.diveintospringrest.api.exceptionhandler;

import com.igoravancinifraga.diveintospringrest.domain.exception.BusinessException;
import com.igoravancinifraga.diveintospringrest.domain.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<CustomerException.Fields> fields = new ArrayList<>();

        for (ObjectError error : ex.getAllErrors()) {
            String fieldName = ((FieldError) error).getField();
//            String message = error.getDefaultMessage();
            String message = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new CustomerException.Fields(fieldName, message));
        }

        CustomerException exception = CustomerException.builder()
                .status(status.value())
                .dateTime(OffsetDateTime.now())
                .title("One or more fields are invalid")
                .fields(fields)
                .build();

        return this.handleExceptionInternal(ex, exception, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException exception, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        CustomerException businessException = CustomerException.builder()
                .status(status.value())
                .dateTime(OffsetDateTime.now())
                .title(exception.getMessage())
                .build();

        return this.handleExceptionInternal(exception, businessException, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException exception, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        CustomerException businessException = CustomerException.builder()
                .status(status.value())
                .dateTime(OffsetDateTime.now())
                .title(exception.getMessage())
                .build();

        return this.handleExceptionInternal(exception, businessException, new HttpHeaders(), status, request);
    }


}

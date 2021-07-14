package com.igoravancinifraga.diveintospringrest.api.controller;

import com.igoravancinifraga.diveintospringrest.domain.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/customer")
    public List<Customer> listar() {
        var cliente1 = new Customer(1L, "Igor Avancini Fraga", "igoravancinifraga@gmail.com", "+5519981351208");
        var cliente2 = new Customer(2L, "Fernanda Menezes", "fer@gmail.com", "12354645");
        var cliente3 = new Customer(3L, "Lucky Lindão", "lucky@gmail.com", "+145632848");

        return Arrays.asList(cliente1, cliente2, cliente3);
    }
}

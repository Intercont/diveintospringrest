package com.igoravancinifraga.diveintospringrest.api.controller;

import com.igoravancinifraga.diveintospringrest.domain.model.Customer;
import com.igoravancinifraga.diveintospringrest.domain.repository.CustomerRepository;
import com.igoravancinifraga.diveintospringrest.domain.service.CustomerCatalogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private CustomerRepository repository;
    private CustomerCatalogService service;

    @GetMapping
    public List<Customer> listCustomers() {
        return repository.findAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> findCustomer(@PathVariable Long customerId) {
        //short version with Lambda funcional
        return repository.findById(customerId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

        //long version for better understanding
//        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
//
//        if (optionalCustomer.isPresent()) {
//            return ResponseEntity.ok(optionalCustomer.get());
//        }
//
//        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@Valid @RequestBody Customer customer) {
        return service.save(customer);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId,
                                                   @Valid @RequestBody Customer customer) {
        if (!repository.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }

        customer.setId(customerId);
        return ResponseEntity.ok(service.save(customer));

    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        if (!repository.existsById(customerId)) {
            return ResponseEntity.notFound().build();
        }

        service.delete(customerId);

        return ResponseEntity.noContent().build(); //no content is commonly used when the answer has no body

    }

}

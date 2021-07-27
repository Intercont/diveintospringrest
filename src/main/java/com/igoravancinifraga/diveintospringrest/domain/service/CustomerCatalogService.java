package com.igoravancinifraga.diveintospringrest.domain.service;

import com.igoravancinifraga.diveintospringrest.domain.exception.BusinessException;
import com.igoravancinifraga.diveintospringrest.domain.model.Customer;
import com.igoravancinifraga.diveintospringrest.domain.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CustomerCatalogService {

    private CustomerRepository customerRepository;

    @Transactional //must be executed within a transaction, otherwise everything will be rolled back
    public Customer save(Customer customer) {
        boolean emailInUse = customerRepository.findByEmail(customer.getEmail())
                .stream()
                .anyMatch(existingCustomer -> !existingCustomer.equals(customer)); //verify if this customer is different or if this is a update

        if (emailInUse) {
            throw new BusinessException("There is already a customer with this email");
        }

        return customerRepository.save(customer);
    }

    @Transactional
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}

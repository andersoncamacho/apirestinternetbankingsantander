package br.com.santander.internetbanking.customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping(value = "/api/customer")
    @Transactional
    public String toCreate(@RequestBody @Valid CustomerRequest request) {
        Customer newCustomer = request.toModel();
        manager.persist(newCustomer);
        return newCustomer.toString();
    }

}

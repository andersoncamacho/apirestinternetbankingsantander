package br.com.santander.internetbanking.datailtransaction;

import br.com.santander.internetbanking.customer.Customer;
import br.com.santander.internetbanking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerDetailController {
    private final CustomerService customerService;

    @Autowired
    public CustomerDetailController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.registerCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers() {
        List<Customer> customer = customerService.getCustomers();
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}

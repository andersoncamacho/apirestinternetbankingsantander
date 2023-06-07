package br.com.santander.internetbanking.dataloader;

import br.com.santander.internetbanking.customer.Customer;
import br.com.santander.internetbanking.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class DataInit implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public DataInit(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Customer customer1 = new Customer("Anderson Camacho", true, BigDecimal.valueOf(100), "123456789", LocalDate.of(1987, 2, 13));
        Customer customer2 = new Customer("Ana Paula", false, BigDecimal.valueOf(500), "977854391", LocalDate.of(1995, 5, 10));

        customerRepository.save(customer1);
        customerRepository.save(customer2);
    }
}
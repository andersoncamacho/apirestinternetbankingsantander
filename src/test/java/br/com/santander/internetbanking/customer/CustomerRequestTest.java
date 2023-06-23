/*
package br.com.santander.internetbanking.customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerRequestTest {
    @Test
    public void testToModelConversion() {
        CustomerRequest request = new CustomerRequest("Anderson Camacho", true, BigDecimal.valueOf(100), "123456789");
        request.setDateOfBirth(LocalDate.of(1990, 1, 1));
        Customer customer = request.toModel();
        Assertions.assertEquals("Anderson Camacho", customer.getName());
        Assertions.assertTrue(customer.isExclusivePlan());
        Assertions.assertEquals(BigDecimal.valueOf(100), customer.getBalance());
        Assertions.assertEquals("123456789", customer.getAccountNumber());
        Assertions.assertEquals(LocalDate.of(1990, 1, 1), customer.getDateOfBirth());
    }
}
*/

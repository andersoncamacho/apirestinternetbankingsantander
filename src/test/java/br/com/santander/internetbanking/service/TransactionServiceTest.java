/*
package br.com.santander.internetbanking.service;

import br.com.santander.internetbanking.customer.Customer;
import br.com.santander.internetbanking.repository.TransactionRepository;
import br.com.santander.internetbanking.transaction.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CustomerService customerService;

    private TransactionService transactionService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        transactionService = new TransactionService(transactionRepository, customerService);
    }

    @Test
    public void testToWithdrawSufficientBalance() {
        Long customerId = 1L;
        BigDecimal transactionValue = BigDecimal.valueOf(100);
        boolean exclusivePlan = false;

        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setBalance(BigDecimal.valueOf(500));
        customer.setExclusivePlan(exclusivePlan);

        when(customerService.getCustomer(customerId)).thenReturn(customer);

        transactionService.toWithdraw(customerId, transactionValue);

        verify(customerService, times(1)).getCustomer(customerId);
        verify(customerService, times(1)).registerCustomer(customer);
        verify(transactionRepository, times(1)).save(any(Transaction.class));
    }

    @Test
    public void testToWithdrawInsufficientBalance() {
        Long customerId = 1L;
        BigDecimal transactionValue = BigDecimal.valueOf(1000);
        boolean exclusivePlan = false;

        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setBalance(BigDecimal.valueOf(500));
        customer.setExclusivePlan(exclusivePlan);

        when(customerService.getCustomer(customerId)).thenReturn(customer);

        assertThrows(RuntimeException.class, () -> transactionService.toWithdraw(customerId, transactionValue));

        verify(customerService, times(1)).getCustomer(customerId);
        verify(customerService, never()).registerCustomer(customer);
        verify(transactionRepository, never()).save(any(Transaction.class));
    }
}

*/

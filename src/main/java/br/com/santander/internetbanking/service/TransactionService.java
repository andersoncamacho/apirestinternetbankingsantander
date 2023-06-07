package br.com.santander.internetbanking.service;

import br.com.santander.internetbanking.customer.Customer;
import br.com.santander.internetbanking.repository.TransactionRepository;
import br.com.santander.internetbanking.transaction.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CustomerService customerService;

    public TransactionService(TransactionRepository transactionRepository, CustomerService customerService) {
        this.transactionRepository = transactionRepository;
        this.customerService = customerService;
    }

    public void toWithdraw(Long customerId, BigDecimal transactionValue) {
        Customer customer = customerService.getCustomer(customerId);
        BigDecimal rateAdministration = calcTaxWithdraw(transactionValue, customer.isExclusivePlan());

        if (customer.getBalance().compareTo(transactionValue.add(rateAdministration)) >= 0) {
            customer.setBalance(customer.getBalance().subtract(transactionValue.add(rateAdministration)));
            customerService.registerCustomer(customer);

            Transaction transaction = new Transaction();
            transaction.setTypeTransaction(Transaction.TypeTransaction.WITHDRAW);
            transaction.setValueTransaction(transactionValue);
            transaction.rateAdministration(rateAdministration);
            transaction.setData(new Date());
            transactionRepository.save(transaction);
        } else {
            throw new RuntimeException("Saldo insuficiente para saque.");
        }
    }

    public void deposit(Long customerId, BigDecimal transactionValue) {
        Customer customer = customerService.getCustomer(customerId);

        customer.setBalance(customer.getBalance().add(transactionValue));
        customerService.registerCustomer(customer);

        Transaction transaction = new Transaction();
        transaction.setTypeTransaction(Transaction.TypeTransaction.DEPOSIT);
        transaction.setValueTransaction(transactionValue);
        transaction.setData(new Date());

        transactionRepository.save(transaction);
    }

    public List<Transaction> getHistoricoTransacoesByDate(Date data) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        Date startOfDay = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date startOfNextDay = calendar.getTime();

        return transactionRepository.findByDataBetween(startOfDay, startOfNextDay);
    }

    private BigDecimal calcTaxWithdraw(BigDecimal transactionValue, boolean exclusivePlan) {
        BigDecimal rateAdministration;

        if (exclusivePlan) {
            rateAdministration = BigDecimal.ZERO;
        } else if (transactionValue.compareTo(BigDecimal.valueOf(100)) <= 0) {
            rateAdministration = BigDecimal.ZERO;
        } else if (transactionValue.compareTo(BigDecimal.valueOf(300)) <= 0) {
            rateAdministration = transactionValue.multiply(BigDecimal.valueOf(0.004));
        } else {
            rateAdministration = transactionValue.multiply(BigDecimal.valueOf(0.01));
        }

        return rateAdministration;
    }

}

package br.com.santander.internetbanking.customer;

import br.com.santander.internetbanking.customvalidation.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerRequest {
    @NotBlank
    private String name;
    @NotNull
    private boolean exclusivePlan;
    @NotNull
    @Min(0)
    private BigDecimal balance;
    @NotBlank
    @Size(min = 9)
    @UniqueValue(domainClass = Customer.class, fieldName = "accountNumber")
    private String accountNumber;
    @NotNull
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;

    public CustomerRequest(@NotBlank String name, @NotNull boolean exclusivePlan, @NotNull @Min(0) BigDecimal balance,
                           @NotBlank @Size(min = 9) String accountNumber) {
        this.name = name;
        this.exclusivePlan = exclusivePlan;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Customer toModel() {
        return new Customer(this.name, this.exclusivePlan, this.balance, this.accountNumber, this.dateOfBirth);
    }

    public void setName(String name) {
        this.name = name;
    }
}

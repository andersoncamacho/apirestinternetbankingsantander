package br.com.santander.internetbanking.customer;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "NewCustomer")
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private boolean exclusivePlan;
    @NotNull
    @Min(0)
    private BigDecimal balance;
    @NotBlank
    @Size(min = 9)
    private String accountNumber;
    @NotNull
    @Past
    private LocalDate dateOfBirth;

    public Customer(@NotBlank String name, @NotNull @Valid boolean exclusivePlan, @NotNull @Min(0) BigDecimal balance,
                    @NotBlank @Size(min = 9) String accountNumber, @NotNull @Past LocalDate dateOfBirth) {
        this.name = name;
        this.exclusivePlan = exclusivePlan;
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.dateOfBirth = dateOfBirth;
    }

    @Deprecated
    public Customer() {}

    public boolean isExclusivePlan() {
        return exclusivePlan;
    }

    @Override
    public String toString() {
        return "NewCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exclusivePlan=" + exclusivePlan +
                ", balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setExclusivePlan(boolean exclusivePlan) {
        this.exclusivePlan = exclusivePlan;
    }
}

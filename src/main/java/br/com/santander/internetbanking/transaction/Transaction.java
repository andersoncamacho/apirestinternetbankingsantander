package br.com.santander.internetbanking.transaction;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity(name = "Transaction")
@Table(name = "transactions")
public class Transaction {

    public enum TypeTransaction {
        WITHDRAW, DEPOSIT
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;
    private BigDecimal transactionValue;
    private BigDecimal rateAdministration;
    private Date data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeTransaction getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(TypeTransaction typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

    public BigDecimal getRateAdministration() {
        return rateAdministration;
    }

    public void setRateAdministration(BigDecimal rateAdministration) {
        this.rateAdministration = rateAdministration;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    public void setValueTransaction(BigDecimal transactionValue) {
       this.transactionValue = transactionValue;
    }

    public void rateAdministration(BigDecimal rateAdministration) {
        this.rateAdministration = rateAdministration;
    }
}

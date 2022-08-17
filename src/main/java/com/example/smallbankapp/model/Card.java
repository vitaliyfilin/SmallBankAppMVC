package com.example.smallbankapp.model;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public Long number;
    public Currency currency;
    public Date expirationDate;
    public Long ccv;
    public BigDecimal balance;
    @ManyToOne
    public User user;

    public Card(Long id, Long number, Currency currency, Date expirationDate, Long ccv, BigDecimal balance, User user) {
        this.id = id;
        this.number = number;
        this.currency = currency;
        this.expirationDate = expirationDate;
        this.ccv = ccv;
        this.balance = balance;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Long getCcv() {
        return ccv;
    }

    public void setCcv(Long ccv) {
        this.ccv = ccv;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Card(Long id, Long number, Currency currency, Date expirationDate, Long ccv, BigDecimal balance) {
        this.id = id;
        this.number = number;
        this.currency = currency;
        this.expirationDate = expirationDate;
        this.ccv = ccv;
        this.balance = balance;
    }
}

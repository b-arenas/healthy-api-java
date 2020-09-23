package com.upc.autentication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "transaction_table")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_code")
    private Long code;
    double amount;
    int num_days;
    String state;
    String date;
    String hour;
    String type_payment;
    String super_market;
    @ManyToOne
    @JoinColumn(name = "user_code")
    private User user;
    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionDetails> transaccionDetalles;

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getNum_days() {
        return num_days;
    }

    public void setNum_days(int num_days) {
        this.num_days = num_days;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getType_payment() {
        return type_payment;
    }

    public void setType_payment(String type_payment) {
        this.type_payment = type_payment;
    }

    public String getSuper_market() {
        return super_market;
    }

    public void setSuper_market(String super_market) {
        this.super_market = super_market;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TransactionDetails> getTransaccionDetalles() {
        return transaccionDetalles;
    }

    public void setTransaccionesDetalles(List<TransactionDetails> transaccionDetalles) {
        this.transaccionDetalles = transaccionDetalles;
    }
}

package com.upc.autentication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "transaction_table")

public class Transaction {
    @Id
    @Column(name = "user_code")
    private Long user_code;
    double price;
    int num_days;
    String state;
    String date;
    String hour;
    String typePyament;
    String shop;

    public Long getUserCode() {
        return user_code;
    }

    public void setUsercode(Long user_code) {
        this.user_code = user_code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public String getTypePyament() {
        return typePyament;
    }

    public void setTypePyament(String typePyament) {
        this.typePyament = typePyament;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }
}

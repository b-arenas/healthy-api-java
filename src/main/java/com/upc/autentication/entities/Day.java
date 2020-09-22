package com.upc.autentication.entities;

import javax.persistence.*;


@Entity
@Table(name = "select_days")
public class Day {
    @Id
    @Column(name = "user_code")
    private Long user_code;
    private boolean monday;
    private boolean tuesday;
    private boolean wendnesday;
    private boolean thursday;
    private boolean friday;
    private boolean saturday;
    private boolean sunday;

    public Long getUserCode() {
        return user_code;
    }
    public void setUserCode(Long user_code) {
        this.user_code = user_code;
    }

    public boolean isMonday() {
        return monday;
    }

    public void setMonday(boolean monday) {
        this.monday = monday;
    }

    public boolean isTuesday() {
        return tuesday;
    }

    public void setTuesday(boolean tuesday) {
        this.tuesday = tuesday;
    }

    public boolean isWendnesday() {
        return wendnesday;
    }

    public void setWendnesday(boolean wendnesday) {
        this.wendnesday = wendnesday;
    }

    public boolean isThursday() {
        return thursday;
    }

    public void setThursday(boolean thursday) {
        this.thursday = thursday;
    }

    public boolean isFriday() {
        return friday;
    }

    public void setFriday(boolean friday) {
        this.friday = friday;
    }

    public boolean isSaturday() {
        return saturday;
    }

    public void setSaturday(boolean saturday) {
        this.saturday = saturday;
    }

    public boolean isSunday() {
        return sunday;
    }

    public void setSunday(boolean sunday) {
        this.sunday = sunday;
    }
}

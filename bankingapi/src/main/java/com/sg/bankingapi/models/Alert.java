package com.sg.bankingapi.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Alert {
    private String alert_id;
    private String customer_number;
    private String account_number;
    private BigDecimal when_balance;
    private BigDecimal account_balance;
    private String email_address;

    public Alert(String alert_id){
        this.alert_id = alert_id;
    }

    public String getAlert_id() {
        return alert_id;
    }
    public String getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(String customer_number) {
        this.customer_number = customer_number;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public BigDecimal getWhen_balance() {
        return when_balance;
    }

    public void setWhen_balance(BigDecimal when_balance) {
        this.when_balance = when_balance;
    }

    public BigDecimal getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(BigDecimal account_balance) {
        this.account_balance = account_balance;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alert alert = (Alert) o;
        return alert_id.equals(alert.alert_id) && Objects.equals(customer_number, alert.customer_number) && Objects.equals(account_number, alert.account_number) && Objects.equals(when_balance, alert.when_balance) && Objects.equals(account_balance, alert.account_balance) && Objects.equals(email_address, alert.email_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alert_id, customer_number, account_number, when_balance, account_balance, email_address);
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alert_id='" + alert_id + '\'' +
                ", customer_number='" + customer_number + '\'' +
                ", account_number='" + account_number + '\'' +
                ", when_balance=" + when_balance +
                ", account_balance=" + account_balance +
                ", email_address='" + email_address + '\'' +
                '}';
    }
}
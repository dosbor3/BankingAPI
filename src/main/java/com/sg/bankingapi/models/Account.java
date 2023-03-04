package com.sg.bankingapi.models;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Account {
    private int account_number;
    private int customer_number;
    private double current_balance;
    private double available_balance;
    private int account_category;
    private boolean isActive;

    private List<Transaction> transations;
    public int getAccount_number() { return account_number; }
    public void setAccount_number(int account_number) { this.account_number = account_number; }
    public int getCustomer_number() { return customer_number; }
    public void setCustomer_number(int customer_number) { this.customer_number = customer_number; }
    public double getCurrent_balance() { return current_balance; }
    public void setCurrent_balance(double current_balance) { this.current_balance = current_balance; }
    public double getAvailable_balance() { return available_balance; }
    public void setAvailable_balance(double available_balance) { this.available_balance = available_balance; }
    public int getAccount_category() { return account_category; }
    public void setAccount_category(int account_category) { this.account_category = account_category; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public List<Transaction> getTransations() { return transations;  }
    public void setTransations(List<Transaction> transations) { this.transations = transations;  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return account_number == account.account_number && customer_number == account.customer_number && Double.compare(account.current_balance, current_balance) == 0 && Double.compare(account.available_balance, available_balance) == 0 && account_category == account.account_category && isActive == account.isActive && Objects.equals(transations, account.transations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account_number, customer_number, current_balance, available_balance, account_category, isActive, transations);
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_number=" + account_number +
                ", customer_number=" + customer_number +
                ", current_balance=" + current_balance +
                ", available_balance=" + available_balance +
                ", account_category=" + account_category +
                ", isActive=" + isActive +
                ", transations=" + transations +
                '}';
    }
}
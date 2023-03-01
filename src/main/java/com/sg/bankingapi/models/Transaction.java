package com.sg.bankingapi.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Transaction {
    private int trans_id;
    private int account_number;
    private int customer_number;
    private int account_type;
    private LocalDateTime trans_date;
    private BigDecimal deposit_amount;
    private BigDecimal withdrawl_amount;
    private BigDecimal total;
    private boolean pending_flag;


    public int getTrans_id() {
        return trans_id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public int getCustomer_number() {
        return customer_number;
    }

    public void setCustomer_number(int customer_number) {
        this.customer_number = customer_number;
    }

    public int getAccount_type() { return account_type; }

    public void setAccount_type(int account_type) { this.account_type = account_type; }

    public LocalDateTime getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(LocalDateTime trans_date) {
        this.trans_date = trans_date;
    }

    public BigDecimal getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(BigDecimal deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public BigDecimal getWithdrawl_amount() {
        return withdrawl_amount;
    }

    public void setWithdrawl_amount(BigDecimal withdrawl_amount) {
        this.withdrawl_amount = withdrawl_amount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isPending_flag() {
        return pending_flag;
    }

    public void setPending_flag(boolean pending_flag) {
        this.pending_flag = pending_flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return trans_id == that.trans_id && account_number == that.account_number && customer_number == that.customer_number && account_type == that.account_type && pending_flag == that.pending_flag && Objects.equals(trans_date, that.trans_date) && Objects.equals(deposit_amount, that.deposit_amount) && Objects.equals(withdrawl_amount, that.withdrawl_amount) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trans_id, account_number, customer_number, account_type, trans_date, deposit_amount, withdrawl_amount, total, pending_flag);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trans_id='" + trans_id + '\'' +
                ", account_number='" + account_number + '\'' +
                ", customer_number='" + customer_number + '\'' +
                ", trans_date=" + trans_date +
                ", deposit_amount=" + deposit_amount +
                ", withdrawl_amount=" + withdrawl_amount +
                ", total=" + total +
                ", pending_flag=" + pending_flag +
                '}';
    }
}
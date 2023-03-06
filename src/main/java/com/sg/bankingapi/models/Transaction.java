package com.sg.bankingapi.models;

import java.time.*;
import java.util.Objects;

public class Transaction {
    private int trans_id;
    private int trans_type;
    private LocalDate trans_date;
    private double amount;
    private double total;
    private boolean pending_flag;

    public int getTrans_id() { return trans_id;  }
    public void setTrans_id(int trans_id) {this.trans_id = trans_id; }
    public int getTrans_type() { return trans_type; }
    public void setTrans_type(int trans_type) { this.trans_type = trans_type; }
    public LocalDate getTrans_date() { return trans_date; }
    public void setTrans_date(LocalDate trans_date) { this.trans_date = trans_date; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount;  }
    public double getTotal() { return total; }
    public void setTotal(double total) {
        this.total = total;
    }
    public boolean getPending_flag() {
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
        return trans_id == that.trans_id && trans_type == that.trans_type && Double.compare(that.amount, amount) == 0 && Double.compare(that.total, total) == 0 && pending_flag == that.pending_flag && trans_date.equals(that.trans_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(trans_id, trans_type, trans_date, amount, total, pending_flag);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trans_id=" + trans_id +
                ", trans_type=" + trans_type +
                ", trans_date=" + trans_date +
                ", amount=" + amount +
                ", total=" + total +
                ", pending_flag=" + pending_flag +
                '}';
    }
}


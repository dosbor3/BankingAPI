package com.sg.bankingapi.models;

import java.math.BigDecimal;
import java.time.*;
import java.util.Objects;

public class Transaction {
    private int trans_id;
    private int trans_type;
    private int account_number;
    private LocalDate trans_date;
    private BigDecimal amount;
    private BigDecimal total;
    private boolean pending_flag;

    public int getTrans_id() {
        return trans_id;
    }

    public void setTrans_id(int trans_id) {this.trans_id = trans_id; }

    public int getTrans_type() { return trans_type; }

    public void setTrans_type(int trans_type) { this.trans_type = trans_type; }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public LocalDate getTrans_date() {
        return trans_date;
    }

    public void setTrans_date(LocalDate trans_date) {
        this.trans_date = trans_date;
    }

    public BigDecimal getAmount() { return amount; }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean getPending_flag() {
        return pending_flag;
    }

    public void setPending_flag(boolean pending_flag) {
        this.pending_flag = pending_flag;
    }


}
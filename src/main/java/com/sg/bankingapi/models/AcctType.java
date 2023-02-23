package com.sg.bankingapi.models;

public class AcctType {
    private int account_type_id;
    private String account_type;
    private String account_description;

    public AcctType(int account_type_id) {
        this.account_type_id = account_type_id;
    }
    public int getAccount_type_id() { return account_type_id;}
    public void setAccount_type(String account_type) { this.account_type = account_type; }
    public String getAccount_type() {
        return account_type;
    }
    public String getAccount_description() {
        return account_description;
    }
    public void setAccount_description(String account_description) {
        this.account_description = account_description;
    }


}

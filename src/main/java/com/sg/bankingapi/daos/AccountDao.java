package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Account;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {
    Account getAccountByAccountNumber(int account_number);
    Account getAccountByCustomerNumber(int customer_number);
    Account addAccount(Account account);
    List<Account> getAllAccounts();
    BigDecimal getAvailableBalance(int account_number);
    BigDecimal getCurrentBalance(int account_number);
    void updateAccount(Account account);
    void deleteAccountByAccountNumber(String account_number);

}

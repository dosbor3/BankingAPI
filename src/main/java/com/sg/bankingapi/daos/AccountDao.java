package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Account;
import com.sg.bankingapi.models.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface AccountDao {
    Account getAccountByAccountNumber(int account_number);
    List<Account> getAllAccounts();
    Account addAccount(Account account);
    void updateAccount(Account account);
    void deleteAccountByAccountNumber(int account_number);
    List<Transaction> getTransactionsForCustomer(int customer_no);
    List<Transaction> getTransactionsForAccount(int acct_no);


}

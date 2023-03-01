package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Transaction;

import java.time.*;
import java.util.*;
public interface TransactionDao {
    Transaction getAccountTransactionById(int trans_id);
    List<Transaction> getAllAccountTransactions();
    List<Transaction> getAllTransactionsForCustomer(int customer_number);
    List<Transaction> getAllAccountWithdrawlsByDate(LocalDate date);
    List<Transaction> getAllAccountDepositsByDate(LocalDate date);
    Transaction addAccountTransaction(Transaction transaction);
    void updateAccountTransaction(Transaction transaction);
    void deleteAccountTransaction(Transaction transaction);

}

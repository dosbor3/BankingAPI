package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Transactions;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;
public interface TransactionsDao {
    Transactions getAccountTransactionsById(int trans_id);
    Transactions getCheckingTransactionsByDateAndTime(LocalDateTime dateTime);
    BigDecimal getAccountDepositAmount(int trans_id);
    BigDecimal getAccountWithdrawlAmount(int trans_id);
    BigDecimal getTotalAccountAmount(int trans_id);
    BigDecimal makeDeposit(BigDecimal funds);
    BigDecimal makeWithdrawl(BigDecimal funds);
    List<Transactions> getAllAccountTransactions();
    List<Transactions> getAllTransactionsForCustomer(int customer_number);
    List<Transactions> getAllAccountWithdrawlsByDate(LocalDate date);
    List<Transactions> getAllAccountDepositsByDate(LocalDate date);
    Transactions addAccountTransaction(Transactions transaction);
    void updateAccountTransactions(Transactions transaction);
    void deleteAccountTransactions(Transactions transaction);

}

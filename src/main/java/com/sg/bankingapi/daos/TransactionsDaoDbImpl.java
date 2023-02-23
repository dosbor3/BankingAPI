package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Transactions;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TransactionsDaoDbImpl implements TransactionsDao {
    @Override
    public Transactions getAccountTransactionsById(int trans_id) {
        return null;
    }

    @Override
    public Transactions getCheckingTransactionsByDateAndTime(LocalDateTime dateTime) {
        return null;
    }

    @Override
    public BigDecimal getAccountDepositAmount(int trans_id) {
        return null;
    }

    @Override
    public BigDecimal getAccountWithdrawlAmount(int trans_id) {
        return null;
    }

    @Override
    public BigDecimal getTotalAccountAmount(int trans_id) {
        return null;
    }

    @Override
    public BigDecimal makeDeposit(BigDecimal funds) {
        return null;
    }

    @Override
    public BigDecimal makeWithdrawl(BigDecimal funds) {
        return null;
    }

    @Override
    public List<Transactions> getAllAccountTransactions() {
        return null;
    }

    @Override
    public List<Transactions> getAllTransactionsForCustomer(int customer_number) {
        return null;
    }

    @Override
    public List<Transactions> getAllAccountWithdrawlsByDate(LocalDate date) {
        return null;
    }

    @Override
    public List<Transactions> getAllAccountDepositsByDate(LocalDate date) {
        return null;
    }

    @Override
    public Transactions addAccountTransaction(Transactions transaction) {
        return null;
    }

    @Override
    public void updateAccountTransactions(Transactions transaction) {

    }

    @Override
    public void deleteAccountTransactions(Transactions transaction) {

    }
}

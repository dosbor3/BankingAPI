package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Transaction;

import java.time.*;
import java.util.*;
public interface TransactionDao {
    Transaction getTransactionById(int trans_id);
    List<Transaction> getAllTransactions();

    /**
     * This method will return a list of all transactions for a given account based on the account_number variable
     * @param account_number, a unique identifier for a spcific account object
     * @return a List of all transactions made by a given account
     */
    List<Transaction> getAllTransactionsByAccountNumber(int account_number);

    /**
     * This method will return a List of ALL transactions made by the customer object with the specific customer_number
     * @param customer_number, a unique identifier for a specific customer object
     * @return, a List of all transactions made by a given customer
     */
    List<Transaction> getAllTransactionsByCustomerNumber(int customer_number);

    /**
     * This method will return a list of transactions made by a customer for a specific type of transaction based on the
     * trans_type variable
     * @param customer_number, unique number specific to a single customer object
     * @param account_number, unique number specific to a single account object
     * @param trans_type
     * @return List structure that holds a specific transaction type for a customer
     */
    List<Transaction> getAllTransactionsTypeByCustomerNumber(int customer_number, int account_number, int trans_type);

    Transaction addTransaction(Transaction transaction);
    void updateTransaction(Transaction transaction);
    void deleteTransaction(int trans_id);

}

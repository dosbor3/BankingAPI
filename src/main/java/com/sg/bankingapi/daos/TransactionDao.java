package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Transaction;
import java.util.*;

public interface TransactionDao {
    /**
     * @param trans_id
     * @return
     */
    Transaction getTransactionById(int trans_id);

    /**
     * @return
     */
    List<Transaction> getAllTransactions();

    /**
     * @param transaction
     * @return
     */
    Transaction addTransaction(Transaction transaction);

    /**
     * @param transaction
     */
    void updateTransaction(Transaction transaction);

    /**
     * @param trans_id
     */
    void deleteTransactionById(int trans_id);

    List<Transaction> getAllTransactionsByAccountNumber(int account_number);

    /**
     * This method will return a list of all transactions for a given account based on the account_number variable
     *
     * @param customer_number, a unique identifier for a spcific account object
     * @return a List of all transactions made by a given account
     */
    List<Transaction> getAllTransactionsByCustomersNumber(int customer_number);
}

//todo 03/02/23 As of now, I have to complete the Transaction DB to match up with the database table,
// I have to complete the controllers, service layer and security.  A Front-end isn't required
//
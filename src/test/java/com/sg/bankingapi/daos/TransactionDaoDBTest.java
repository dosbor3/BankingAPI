package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class TransactionDaoDBTest {
    @Autowired
    TransactionDao transactionDao;

    @BeforeEach
    void setUp() {
        List<Transaction> transactions = transactionDao.getAllTransactions();
        for(Transaction transaction: transactions) {
            transactionDao.deleteTransactionById(transaction.getTrans_id());
        }
    }

    @Test
    void testAddAndGetTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTrans_type(3);
        transaction.setTrans_date(LocalDate.now());
        transaction.setAmount(125.00);
        transaction.setTotal(transaction.getAmount());
        transaction.setPending_flag(false);
        transaction = transactionDao.addTransaction(transaction);
        transaction.setTrans_id(transaction.getTrans_id());
        Transaction trans_fromDao = transactionDao.getTransactionById(transaction.getTrans_id());
        assertEquals(transaction, trans_fromDao);
    }

    @Test
    void testUpdateTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTrans_type(3);
        transaction.setTrans_date(LocalDate.now());
        transaction.setAmount(125.00);
        transaction.setTotal(transaction.getAmount());
        transaction.setPending_flag(false);
        transaction = transactionDao.addTransaction(transaction);
        transaction.setTrans_id(transaction.getTrans_id());
        Transaction trans_fromDao = transactionDao.getTransactionById(transaction.getTrans_id());
        assertEquals(transaction, trans_fromDao);

        transaction.setTrans_type(5);
        transactionDao.updateTransaction(transaction);
        assertNotEquals(transaction, trans_fromDao);
    }

    @Test
    void testDeleteTransaction() {
        Transaction transaction = new Transaction();
        transaction.setTrans_type(3);
        transaction.setTrans_date(LocalDate.now());
        transaction.setAmount(125.00);
        transaction.setTotal(transaction.getAmount());
        transaction.setPending_flag(false);
        transaction = transactionDao.addTransaction(transaction);
        transaction.setTrans_id(transaction.getTrans_id());
        Transaction trans_fromDao = transactionDao.getTransactionById(transaction.getTrans_id());
        assertEquals(transaction, trans_fromDao);

        transactionDao.deleteTransactionById(transaction.getTrans_id());
        trans_fromDao = transactionDao.getTransactionById(transaction.getTrans_id());
        assertNull(trans_fromDao);

    }
}
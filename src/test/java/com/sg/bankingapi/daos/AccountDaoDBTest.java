package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.*;
import com.sg.bankingapi.models.Transaction;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AccountDaoDBTest {

    @Autowired
    AccountDao accountDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    TransactionDao transactionDao;

    @Autowired
    CustomerAddressDao customerAddressDao;

    public AccountDaoDBTest() {}

    @BeforeAll
    public static void setUpClass() {}

    @AfterAll
    public static void tearDownClass() {}


    @BeforeEach
    void setUp() {
        List<Account> accounts = accountDao.getAllAccounts();
        for(Account account: accounts) {
            accountDao.deleteAccountByAccountNumber(account.getAccount_number());
        }

        List<Customer> customers = customerDao.getAllCustomers();
        for(Customer customer: customers) {
            customerDao.deleteCustomerById(customer.getCustomer_number());
        }

        List<Transaction> transactions = transactionDao.getAllTransactions();
        for(Transaction transaction: transactions) {
            transactionDao.deleteTransaction(transaction.getTrans_id());
        }

        List<Address> addresses = customerAddressDao.getAllAddress();
        for(Address address: addresses) {
            customerAddressDao.deleteAddressById(address.getAddress_id());
        }
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAndGetAccount() {
        Account account = new Account();
        account.setAccount_number(1);
        account.setCustomer_number(11);
        account.setCurrent_balance(new BigDecimal("22.50"));
        account.setAvailable_balance(new BigDecimal("15.50"));
        account.setAccount_category(1);
        account.setActive(true);
        account = accountDao.addAccount(account);

        Account fromDao = accountDao.getAccountByAccountNumber(account.getAccount_number());

        assertEquals(account, fromDao);
    }

    @Test
    void getAllAccounts() {
    }

    @Test
    void updateAccount() {
    }

    @Test
    void deleteAccountByAccountNumber() {
    }
}
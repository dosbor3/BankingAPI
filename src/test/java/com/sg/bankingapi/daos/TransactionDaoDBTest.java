//package com.sg.bankingapi.daos;
//
//import com.sg.bankingapi.models.*;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import static org.junit.jupiter.api.Assertions.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@SpringBootTest
//class TransactionDaoDBTest {
//    @Autowired
//    AccountDao accountDao;
//
//    @Autowired
//    CustomerDao customerDao;
//
//    @Autowired
//    AddressDao addressDao;
//
//    @Autowired
//    TransactionDao transactionDao;
//
//    @BeforeEach
//    void setUp() {
//        List<Customer> customers = customerDao.getAllCustomers();
//        for(Customer customer: customers) {
//            customerDao.deleteCustomerById(customer.getCustomer_number());
//        }
//        List<Transaction> transactions = transactionDao.getAllTransactions();
//        for(Transaction transaction: transactions) {
//            transactionDao.deleteTransactionById(transaction.getTrans_id());
//        }
//
//        List<Account> accounts = accountDao.getAllAccounts();
//        for(Account account: accounts) {
//            accountDao.deleteAccountByAccountNumber(account.getAccount_number());
//        }
//
//        List<Address> addresses = addressDao.getAllAddress();
//        for(Address address: addresses) {
//            addressDao.deleteAddressById(address.getAddress_id());
//        }
//    }
//
//    @Test
//    void testAddAndGetTransaction() {
//        Address address = new Address();
//        address.setStreet("17339 Harvey Blvd");
//        address.setCity("Miami");
//        address.setState("Florida");
//        address.setZipcode("86753");
//        address = addressDao.addAddress(address);
//        Address addr_fromDao = addressDao.getAddressById(address.getAddress_id());
//        assertEquals(address, addr_fromDao);
//
//
//        Customer customer = new Customer();
//        customer.setFirst_name("Sheril");
//        customer.setLast_name("Davis");
//        customer.setAddress(address.getAddress_id());
//        customer.setPhone(("555-555-5555"));
//        customer.setEmail_address("someemail@some.com");
//        customer.setActive(true);
//        customer = customerDao.addCustomer(customer);
//        customer.setCustomerNumber(customer.getCustomer_number());
//        Customer cust_fromDao = customerDao.getCustomerById(customer.getCustomer_number());
//        assertEquals(customer, cust_fromDao);
//
//
//        Account account = new Account();
//        account.setCustomer_number(customer.getCustomer_number());
//        account.setCurrent_balance(22.50);
//        account.setAvailable_balance(15.50);
//        account.setAccount_category(1);
//        account.setActive(true);
//        account = accountDao.addAccount(account);
//        account.setAccount_number(account.getAccount_number());
//        Account acct_fromDao = accountDao.getAccountByAccountNumber(account.getAccount_number());
//
//        assertEquals(account, acct_fromDao);
//
//        Transaction transaction = new Transaction();
//
//        transaction.setTrans_type(3);
//        transaction.setAccount_number(account.getAccount_number());
//        transaction.setTrans_date(LocalDate.now());
//        transaction.setAmount(125.00);
//        transaction.setTotal(transaction.getAmount());
//        transaction.setPending_flag(false);
//        transaction = transactionDao.addTransaction(transaction);
//        transaction.setTrans_id(transaction.getTrans_id());
//
//        Transaction trans_fromDao = transactionDao.getTransactionById(transaction.getTrans_id());
//
//        assertEquals(transaction, trans_fromDao);
//
//    }
//
//    @Test
//    void updateTransaction() {
//    }
//
//    @Test
//    void deleteTransaction() {
//    }
//}
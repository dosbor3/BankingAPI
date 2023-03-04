package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class AccountDaoDBTest {

    @Autowired
    AccountDao accountDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    AddressDao addressDao;

    @BeforeEach
    void setUp() {
        List<Customer> customers = customerDao.getAllCustomers();
        for(Customer customer: customers) {
            customerDao.deleteCustomerById(customer.getCustomer_number());
        }

        List<Account> accounts = accountDao.getAllAccounts();
        for(Account account: accounts) {
            accountDao.deleteAccountByAccountNumber(account.getAccount_number());
        }


    }

    @Test
    void testAddAndGetAccount() {
        Address address = new Address();
        address.setStreet("17339 Harvey Blvd");
        address.setCity("Miami");
        address.setState("Florida");
        address.setZipcode("86753");
        address = addressDao.addAddress(address);
        Address addr_fromDao = addressDao.getAddressById(address.getAddress_id());
        assertEquals(address, addr_fromDao);


        Customer customer = new Customer();
        customer.setFirst_name("Sheril");
        customer.setLast_name("Davis");
        customer.setAddress(address.getAddress_id());
        customer.setPhone(("555-555-5555"));
        customer.setEmail_address("someemail@some.com");
        customer.setActive(true);
        customer = customerDao.addCustomer(customer);
        customer.setCustomerNumber(customer.getCustomer_number());
        Customer cust_fromDao = customerDao.getCustomerById(customer.getCustomer_number());
        assertEquals(customer, cust_fromDao);


        Account account = new Account();
        account.setCustomer_number(customer.getCustomer_number());
        account.setCurrent_balance(22.50);
        account.setAvailable_balance(15.50);
        account.setAccount_category(1);
        account.setActive(true);
        account = accountDao.addAccount(account);
        account.setAccount_number(account.getAccount_number());
        Account acct_fromDao = accountDao.getAccountByAccountNumber(account.getAccount_number());

        assertEquals(account, acct_fromDao);
    }

    @Test
    void testGetAllAccounts() {
        Address address = new Address();
        address.setStreet("17339 Harvey Blvd");
        address.setCity("Miami");
        address.setState("Florida");
        address.setZipcode("86753");
        address = addressDao.addAddress(address);
        Address addr_fromDao = addressDao.getAddressById(address.getAddress_id());

        Customer customer = new Customer();
        customer.setFirst_name("Sheril");
        customer.setLast_name("Davis");
        customer.setAddress(address.getAddress_id());
        customer.setPhone(("555-555-5555"));
        customer.setEmail_address("someemail@some.com");
        customer.setActive(true);
        customer = customerDao.addCustomer(customer);
        customer.setCustomerNumber(customer.getCustomer_number());
        Customer cust_fromDao = customerDao.getCustomerById(customer.getCustomer_number());


        Account account = new Account();
        account.setCustomer_number(customer.getCustomer_number());
        account.setCurrent_balance(22.50);
        account.setAvailable_balance(15.50);
        account.setAccount_category(1);
        account.setActive(true);
        account = accountDao.addAccount(account);


        Account account2 = new Account();
        account2.setCustomer_number(customer.getCustomer_number());
        account2.setCurrent_balance(1456.98);
        account2.setAvailable_balance(1567.50);
        account2.setAccount_category(2);
        account2.setActive(true);
        account2 = accountDao.addAccount(account2);

        List<Account> accounts = accountDao.getAllAccounts();

        assertEquals(2, accounts.size());
        assertTrue(accounts.contains(account));
        assertTrue(accounts.contains(account2));
    }

    @Test
    void testUpdateAccount() {
        Address address = new Address();
        address.setStreet("17339 Harvey Blvd");
        address.setCity("Miami");
        address.setState("Florida");
        address.setZipcode("86753");
        address = addressDao.addAddress(address);
        Address addr_fromDao = addressDao.getAddressById(address.getAddress_id());

        Customer customer = new Customer();
        customer.setFirst_name("Sheril");
        customer.setLast_name("Davis");
        customer.setAddress(address.getAddress_id());
        customer.setPhone(("555-555-5555"));
        customer.setEmail_address("someemail@some.com");
        customer.setActive(true);
        customer = customerDao.addCustomer(customer);
        customer.setCustomerNumber(customer.getCustomer_number());
        Customer cust_fromDao = customerDao.getCustomerById(customer.getCustomer_number());

        Account account = new Account();
        account.setCustomer_number(customer.getCustomer_number());
        account.setCurrent_balance(22.50);
        account.setAvailable_balance(15.50);
        account.setAccount_category(1);
        account.setActive(true);
        account = accountDao.addAccount(account);

        Account acct_fromDao = accountDao.getAccountByAccountNumber(account.getAccount_number());
        assertEquals(account, acct_fromDao);

        Customer customer2 = new Customer();
        customer2.setFirst_name("Johnny");
        customer2.setLast_name("Bravo");
        customer2.setAddress(address.getAddress_id());
        customer2.setPhone(("888-257-4789"));
        customer2.setEmail_address("shrek@bigBangTheory.com");
        customer2.setActive(false);
        customer2 = customerDao.addCustomer(customer2);
        customer2.setCustomerNumber(customer2.getCustomer_number());
        Customer cust2_fromDao = customerDao.getCustomerById(customer2.getCustomer_number());

        account.setCustomer_number(customer2.getCustomer_number());
        accountDao.updateAccount(account);

        assertNotEquals(account, acct_fromDao);

        acct_fromDao = accountDao.getAccountByCustomerNumber(account.getCustomer_number());

        assertEquals(account, acct_fromDao);
        
    }
    @Test
    void testDeleteAccountByAccountNumber() {
        Address address = new Address();
        address.setStreet("17339 Harvey Blvd");
        address.setCity("Miami");
        address.setState("Florida");
        address.setZipcode("86753");
        address = addressDao.addAddress(address);
        Address addr_fromDao = addressDao.getAddressById(address.getAddress_id());

        Customer customer = new Customer();
        customer.setFirst_name("Sheril");
        customer.setLast_name("Davis");
        customer.setAddress(address.getAddress_id());
        customer.setPhone(("555-555-5555"));
        customer.setEmail_address("someemail@some.com");
        customer.setActive(true);
        customer = customerDao.addCustomer(customer);
        customer.setCustomerNumber(customer.getCustomer_number());
        Customer cust_fromDao = customerDao.getCustomerById(customer.getCustomer_number());

        Account account = new Account();
        account.setCustomer_number(customer.getCustomer_number());
        account.setCurrent_balance(22.50);
        account.setAvailable_balance(15.50);
        account.setAccount_category(1);
        account.setActive(true);
        account = accountDao.addAccount(account);
        Account fromDao = accountDao.getAccountByAccountNumber(account.getAccount_number());

        assertEquals(account, fromDao);

        accountDao.deleteAccountByAccountNumber(account.getAccount_number());

        fromDao = accountDao.getAccountByAccountNumber(account.getAccount_number());
        assertNull(fromDao);

        //todo remove alertDao and alertDaoImpl
        //todo complete testing
        //todo complete controllers
        //research REACT

    }
}
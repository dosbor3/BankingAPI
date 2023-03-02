package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CustomerDaoDBTest {
    @Autowired
    CustomerDao customerDao;

    @Autowired
    AddressDao addressDao;

    @Autowired
    AccountDao accountDao;

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

        List<Address> addresses = addressDao.getAllAddress();
        for(Address address: addresses) {
            addressDao.deleteAddressById(address.getAddress_id());
        }
    }

    @Test
    void testAddAndGetCustomer() {
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
    }

    @Test
    void updateCustomer() {
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

        customer.setFirst_name("Updated");
        customerDao.updateCustomer(customer);
        assertNotEquals(customer, cust_fromDao);

        cust_fromDao = customerDao.getCustomerById(customer.getCustomer_number());

        assertEquals(customer, cust_fromDao);
    }

    @Test
    void deleteCustomerById() {
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

        Account account = new Account();
        account.setCustomer_number(customer.getCustomer_number());
        account.setCurrent_balance(22.50);
        account.setAvailable_balance(15.50);
        account.setAccount_category(1);
        account.setActive(true);
        account = accountDao.addAccount(account);
        Account fromDao = accountDao.getAccountByAccountNumber(account.getAccount_number());



        assertEquals(customer, cust_fromDao);

        customerDao.deleteCustomerById(customer.getCustomer_number());

        cust_fromDao = customerDao.getCustomerById(customer.getCustomer_number());
        assertNull(cust_fromDao);

        assertEquals(account, fromDao);

        accountDao.deleteAccountByAccountNumber(account.getAccount_number());

        fromDao = accountDao.getAccountByAccountNumber(account.getAccount_number());
        assertNull(fromDao);


    }
}
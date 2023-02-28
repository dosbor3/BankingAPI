package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Customer;

import java.util.*;

public interface CustomerDao {
    /**
     *
     * @param cust_number an integer that uniquely identifies a customer object
     * @return returns the Customer object specific to the cust_number param passed in
     */
    Customer getCustomerById(int cust_number);

    /**
     *
     * @return a list of Customers
     */
    List getAllCustomers();

    /**
     *
     * @param customer
     * @return the Customer object with id added by DB
     */
    Customer addCustomer(Customer customer);

    /**
     *
     * @param customer a customer object
     */
    void updateCustomer(Customer customer);

    void deleteCustomerById(int cust_number);

}

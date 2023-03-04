package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerDaoDB implements CustomerDao{

    private final JdbcTemplate jdbc;

    @Autowired
    public CustomerDaoDB(JdbcTemplate jdbc) { this.jdbc = jdbc; }
    /**
     * @param cust_number an integer that uniquely identifies a customer object
     * @return returns the Customer object specific to the cust_number param passed in
     */
    @Override
    public Customer getCustomerById(int cust_number) {
        try {
            final String GET_CUST_BY_ID = "SELECT * FROM Customer WHERE customer_number = ?";
            return jdbc.queryForObject(GET_CUST_BY_ID, new CustomerMapper(), cust_number);

        }catch (DataAccessException ex) {
            return null;
        }
    }

    /**
     * @return a list of Customers
     */
    @Override
    public List getAllCustomers() {
        final String GET_ALL_CUSTOMERS = "SELECT * FROM Customer";
        return jdbc.query(GET_ALL_CUSTOMERS, new CustomerMapper());
    }

    /**
     * @param customer
     * @return the Customer object with id added by DB
     */
    @Override
    @Transactional
    public Customer addCustomer(Customer customer) {
        final String INSERT_CUSTOMER = "INSERT INTO Customer(first_name, last_name, address_id, phone, email, isActive)" +
                " VALUES(?,?,?,?,?,?)";
        jdbc.update(INSERT_CUSTOMER,
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getEmail_address(),
                customer.isActive());
        int newNumber = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        customer.setCustomerNumber(newNumber);
        return customer;
    }

    /**
     * @param customer a customer object
     */
    @Override
    public void updateCustomer(Customer customer) {
        final String UPDATE_CUSTOMER = "UPDATE Customer SET first_name = ?, last_name = ?, address_id = ?," +
                "phone = ?, email = ?, isActive = ? WHERE customer_number = ?";
        jdbc.update(UPDATE_CUSTOMER,
                customer.getFirst_name(),
                customer.getLast_name(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getEmail_address(),
                customer.isActive(),
                customer.getCustomer_number());

    }

    @Override
    @Transactional
    public void deleteCustomerById(int cust_number) {
        final String DELETE_TRANS_CUST = "DELETE FROM ts.* FROM Transaction_Customer cs "
                +" JOIN  Transaction t ON ts.transId = t.trans_id WHERE c.customer_number = ?";
        jdbc.update(DELETE_TRANS_CUST, cust_number);

        final String DELETE_ACCOUNT_OF_CUSTOMER = "DELETE FROM Account WHERE customer_number = ?";
        jdbc.update(DELETE_ACCOUNT_OF_CUSTOMER, cust_number);

        final String DELETE_CUSTOMER = "DELETE FROM Customer WHERE customer_number = ?";
        jdbc.update(DELETE_CUSTOMER, cust_number);
    }

    public static final class CustomerMapper implements RowMapper<Customer> {

        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerNumber(rs.getInt("customer_number"));
            customer.setFirst_name(rs.getString("first_name"));
            customer.setLast_name(rs.getString("last_name"));
            customer.setAddress(rs.getString("address_id"));
            customer.setPhone(rs.getString("phone"));
            customer.setEmail_address(rs.getString("email"));
            customer.setActive(rs.getBoolean("isActive"));

            return customer;
        }
    }
}

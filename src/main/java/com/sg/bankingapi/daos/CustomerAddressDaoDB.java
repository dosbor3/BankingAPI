package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Address;
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
public class CustomerAddressDaoDB implements CustomerAddressDao {
    private final JdbcTemplate jdbc;
    @Autowired
    public CustomerAddressDaoDB(JdbcTemplate jdbc) {this.jdbc = jdbc; }
    /**
     * @param address_id
     * @return
     */
    @Override
    public Address getAddressById(int address_id) {
        try {
            final String GET_CUST_BY_ID = "SELECT * FROM Address WHERE address_id = ?";
            return jdbc.queryForObject(GET_CUST_BY_ID, new AddressMapper(), address_id);

        }catch (DataAccessException ex) {
            return null;
        }
    }

    /**
     * @return
     */
    @Override
    public List<Address> getAllAddress() {
        final String SELECT_ALL_ADDRESSES = "SELECT * FROM Address";
        return jdbc.query(SELECT_ALL_ADDRESSES, new AddressMapper());
    }

    /**
     * @param address
     * @return
     */
    @Override
    @Transactional
    public Address addAddress(Address address) {
        final String INSERT_ADDRESS = "INSERT INTO Address(street, city, state, zipcode) "
                + "VALUES(?,?,?,?)";
        jdbc.update(INSERT_ADDRESS,
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipcode());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        address.setAddress_id(newId);
        return address;
    }

    /**
     * @param address
     */
    @Override
    public void updateAddress(Address address) {
        final String UPDATE_ADDRESS = "UPDATE Address SET street = ?, city = ?, state = ?, zipcode = ? "
                + "WHERE address_id = ?";
        jdbc.update(UPDATE_ADDRESS,
                address.getStreet(),
                address.getCity(),
                address.getState(),
                address.getZipcode(),
                address.getAddress_id());
    }

    /**
     * @param address_id
     */
    @Override
    @Transactional
    public void deleteAddressById(int address_id) {
        final String DELETE_CUSTOMER = "DELETE FROM Customer WHERE address_id = ?";
        jdbc.update(DELETE_CUSTOMER, address_id);

        final String DELETE_ADDRESS = "DELETE FROM Address WHERE address_id = ?";
        jdbc.update(DELETE_ADDRESS, address_id);
    }
    public static final class AddressMapper implements RowMapper<Address> {

        @Override
        public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
            Address address = new Address();
            address.setAddress_id(rs.getInt("address_id"));
            address.setStreet(rs.getString("street"));
            address.setCity(rs.getString("city"));
            address.setState(rs.getString("state"));
            address.setZipcode(rs.getString("zipcode"));

            return address;
        }
    }


}

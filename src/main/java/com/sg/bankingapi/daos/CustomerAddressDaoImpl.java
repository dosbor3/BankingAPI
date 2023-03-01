package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Address;

import java.util.List;

public class CustomerAddressDaoImpl implements CustomerAddressDao {
    /**
     * @param cust_number
     * @return
     */
    @Override
    public Address getCustomerByAddress(int cust_number) {
        return null;
    }

    /**
     * @return
     */
    @Override
    public List<Address> getAllAddress() {
        return null;
    }

    /**
     * @param address
     * @return
     */
    @Override
    public Address addAddress(Address address) {
        return null;
    }

    /**
     * @param address
     */
    @Override
    public void updateAddress(Address address) {

    }

    /**
     * @param address_id
     */
    @Override
    public void deleteAddressById(int address_id) {

    }

    /**
     * @param cust_id
     * @return
     */
    @Override
    public List<Address> getAllAddressesForCustomer(int cust_id) {
        return null;
    }
}

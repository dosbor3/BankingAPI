package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Address;

import java.util.List;

public interface CustomerAddressDao {
    /**
     *
     * @param cust_number
     * @return
     */
    Address getCustomerByAddress(int cust_number);

    /**
     *
     * @return
     */
    List<Address> getAllAddress();


    /**
     *
     * @param address
     * @return
     */
    Address addAddress(Address address);

    /**
     *
     * @param address
     */
    void updateAddress(Address address);

    /**
     *
     * @param address_id
     */
    void deleteAddressById(int address_id);

    /**
     *
     * @param cust_id
     * @return
     */
    List<Address> getAllAddressesForCustomer(int cust_id);

}

package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Address;

import java.util.List;

public interface CustomerAddressDao {
    /**
     *
     * @param address_id
     * @return
     */
    Address getAddressById(int address_id);

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
}

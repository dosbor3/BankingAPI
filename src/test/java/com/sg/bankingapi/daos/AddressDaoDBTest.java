package com.sg.bankingapi.daos;

import com.sg.bankingapi.models.Address;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

@SpringBootTest
public class AddressDaoDBTest {
    @Autowired
    AddressDao addressDao;

    @BeforeEach
    void setUp() {
        List<Address> addresses = addressDao.getAllAddress();
        for(Address address: addresses) {
            addressDao.deleteAddressById(address.getAddress_id());
        }
    }

    @Test
    void testAddAndGetAddress() {
        Address address = new Address();
        address.setStreet("17339 Harvey Blvd");
        address.setCity("Miami");
        address.setState("Florida");
        address.setZipcode("86753");
        address = addressDao.addAddress(address);
        Address addr_fromDao = addressDao.getAddressById(address.getAddress_id());
        assertEquals(address, addr_fromDao);
    }

    @Test
    void testUpdateAddress() {
        Address address = new Address();
        address.setStreet("17339 Harvey Blvd");
        address.setCity("Miami");
        address.setState("Florida");
        address.setZipcode("86753");
        address = addressDao.addAddress(address);
        Address addr_fromDao = addressDao.getAddressById(address.getAddress_id());
        assertEquals(address, addr_fromDao);

        Address address2 = new Address();
        address2.setStreet("17339 Harvey Blvd");
        address2.setCity("Miami");
        address2.setState("Florida");
        address2.setZipcode("86753");
        address2 = addressDao.addAddress(address2);
        Address addr2_fromDao = addressDao.getAddressById(address2.getAddress_id());

        address.setAddress_id(address2.getAddress_id());
        addressDao.updateAddress(address);

        assertNotEquals(address, addr_fromDao);

        addr_fromDao = addressDao.getAddressById(address.getAddress_id());

        assertEquals(address, addr_fromDao);
    }

    @Test
    void testDeleteAddressById() {
        Address address = new Address();
        address.setStreet("17339 Harvey Blvd");
        address.setCity("Miami");
        address.setState("Florida");
        address.setZipcode("86753");
        address = addressDao.addAddress(address);

        Address addr_fromDao = addressDao.getAddressById(address.getAddress_id());
        assertEquals(address, addr_fromDao);

        addressDao.deleteAddressById(address.getAddress_id());

        addr_fromDao = addressDao.getAddressById(address.getAddress_id());
        assertNull(addr_fromDao);

    }
}
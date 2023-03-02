package com.sg.bankingapi.models;

import java.util.Objects;

public class Address {
    private int address_id;
    private String Street;
    private String City;
    private String State;
    private String zipcode;
    public int getAddress_id() { return address_id; }
    public void setAddress_id(int address_id) { this.address_id = address_id; }
    public String getStreet() { return Street;  }
    public void setStreet(String street) { Street = street; }
    public String getCity() { return City; }
    public void setCity(String city) { City = city; }
    public String getState() { return State; }
    public void setState(String state) { State = state; }
    public String getZipcode() { return zipcode; }
    public void setZipcode(String zipcode) { this.zipcode = zipcode; }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return address_id == address.address_id && Objects.equals(Street, address.Street) && Objects.equals(City, address.City) && Objects.equals(State, address.State) && Objects.equals(zipcode, address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address_id, Street, City, State, zipcode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "customer_number='" + address_id + '\'' +
                ", Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
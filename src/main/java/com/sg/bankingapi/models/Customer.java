package com.sg.bankingapi.models;
import java.util.Objects;

public class Customer {
    private int customer_number;
    private String first_name;
    private String last_name;
    private int address_id;
    private String phone;
    private String email_address;
    private boolean isActive;


    public Customer(int customer_number) {
        this.customer_number = customer_number;
    }


    public int getCustomer_number() {
        return customer_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAddress() {
        return address_id;
    }

    public void setAddress(int address_id) {
        this.address_id = address_id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customer_number == customer.customer_number && address_id == customer.address_id && isActive == customer.isActive && Objects.equals(first_name, customer.first_name) && Objects.equals(last_name, customer.last_name) && Objects.equals(phone, customer.phone) && Objects.equals(email_address, customer.email_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_number, first_name, last_name, address_id, phone, email_address, isActive);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_number='" + customer_number + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address=" + address_id +
                ", isActive=" + isActive +
                ", phone='" + phone + '\'' +
                ", email_address='" + email_address + '\'' +
                '}';
    }
}
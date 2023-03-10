package com.sg.bankingapi.models;
import java.util.Objects;

public class Customer {
    private int customer_number;
    //@NotBlank(message = "First name must not be empty")
    //@Size(max = 50, message = "First name must not exceed 50 characters")
    private String first_name;
    //@NotBlank(message = "Last name must not be empty")
    //@Size(max = 50, message = "Last name must not exceed 50 characters")
    private String last_name;
    private String address;
    private String phone;
    private String email_address;
    private boolean isActive;
    public int getCustomer_number() {
        return customer_number;
    }
    public void setCustomerNumber(int customer_number) {
        this.customer_number = customer_number;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address_id) {
        this.address = address_id;
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
    public boolean isActive() {
        return isActive;
    }
    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customer_number == customer.customer_number && isActive == customer.isActive && Objects.equals(first_name, customer.first_name) && Objects.equals(last_name, customer.last_name) && Objects.equals(address, customer.address) && Objects.equals(phone, customer.phone) && Objects.equals(email_address, customer.email_address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer_number, first_name, last_name, address, phone, email_address, isActive);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_number='" + customer_number + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address=" + address +
                ", isActive=" + isActive +
                ", phone='" + phone + '\'' +
                ", email_address='" + email_address + '\'' +
                '}';
    }
}
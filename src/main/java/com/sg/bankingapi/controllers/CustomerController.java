package com.sg.bankingapi.controllers;

import com.sg.bankingapi.daos.AccountDao;
import com.sg.bankingapi.daos.CustomerDao;
import com.sg.bankingapi.daos.TransactionDao;
import com.sg.bankingapi.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerDao customerDao;
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    AccountDao accountDao;

    @GetMapping("customers")
    public String displayCustomers(Model model) {
        List<Customer> customers = customerDao.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customers";
    }

    @PostMapping("addCustomer")
    public String addCustomer(String first_name, String last_name, String address, String phone, String email_address, String isActive ) {
        Customer customer = new Customer();
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setEmail_address(email_address);
        customer.setActive(Boolean.parseBoolean(isActive));

        customerDao.addCustomer(customer);
        return "redirect:/customers";
//    public String addCustomer(HttpServletRequest request) {
//        String first_name = request.getParameter("first_name");
//        String last_name = request.getParameter("last_name");
//        String address = request.getParameter("address");
//        String phone = request.getParameter("phone");
//        String email_address = request.getParameter("email_address");
//        boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));
//
//        Customer customer = new Customer();
//        customer.setFirst_name(first_name);
//        customer.setLast_name(last_name);
//        customer.setAddress(address);
//        customer.setPhone(phone);
//        customer.setEmail_address(email_address);
//        customer.setActive(isActive);
//        customerDao.addCustomer(customer);

//        return "redirect:/customers";
    }

    @GetMapping("deleteCustomer")
    public String deleteCustomer(String customer_number) {
        Customer customer = new Customer();
        customer.setCustomerNumber(Integer.parseInt(customer_number));
        int cust_no = customer.getCustomer_number();
        customerDao.deleteCustomerById(cust_no);
        return "redirect:/customers";
    }

    @GetMapping("editCustomer")
    public String editCustomer(String customer_number) {
        Customer customer = new Customer();
        customer.setCustomerNumber(Integer.parseInt(customer_number));
        int cust_no = customer.getCustomer_number();
        customerDao.updateCustomer(customer);
        return "editCustomer";
    }


}

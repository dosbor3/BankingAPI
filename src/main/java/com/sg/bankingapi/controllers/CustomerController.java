package com.sg.bankingapi.controllers;

import com.sg.bankingapi.daos.AccountDao;
import com.sg.bankingapi.daos.CustomerDao;
import com.sg.bankingapi.daos.TransactionDao;
import com.sg.bankingapi.models.Customer;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
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
    public String addCustomer(HttpServletRequest request) {
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        boolean isActive = Boolean.parseBoolean(request.getParameter("isActive"));

        Customer customer = new Customer();
        customer.setFirst_name(first_name);
        customer.setLast_name(last_name);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setEmail_address(email);
        customer.setActive(isActive);

        customerDao.addCustomer(customer);

        return "redirect:/customers";
    }

    @GetMapping("deleteCustomer")
    public String deleteCustomer(HttpServletRequest request) {
        int cust_no = Integer.parseInt(request.getParameter("customer_number"));
        customerDao.deleteCustomerById(cust_no);
        return "redirect:/customers";
    }

    @GetMapping("editCustomer")
    public String editCustomer(HttpServletRequest request, Model model) {
        int cust_no = Integer.parseInt(request.getParameter("customer_number"));
        Customer customer = customerDao.getCustomerById(cust_no);

       model.addAttribute("customer", customer);
        return "editCustomer";
    }


}

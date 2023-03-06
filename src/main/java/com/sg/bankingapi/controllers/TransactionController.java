package com.sg.bankingapi.controllers;

import com.sg.bankingapi.daos.AccountDao;
import com.sg.bankingapi.daos.CustomerDao;
import com.sg.bankingapi.daos.TransactionDao;
import com.sg.bankingapi.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TransactionController {
    @Autowired
    CustomerDao customerDao;
    @Autowired
    TransactionDao transactionDao;
    @Autowired
    AccountDao accountDao;

    @GetMapping("transactions")
    public String displayTransactions(Model model) {
        List<Transaction> transactions = transactionDao.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transactions";
    }
    @PostMapping("addTransaction")
    public String addTransaction(String trans_type, String trans_date, String amount, String total, String pending_flag) {
//        int trans_type = Integer.parseInt(request.getParameter("trans_type"));
//        LocalDate trans_date = LocalDate.parse(request.getParameter("trans_date"));
//        double amount = Double.parseDouble(request.getParameter("amount"));
//        double total = Double.parseDouble(request.getParameter("total"));
//        boolean pending_flag = Boolean.parseBoolean(request.getParameter("pending_flag"));

        Transaction transaction = new Transaction();
        transaction.setTrans_type(Integer.parseInt(trans_type));
        transaction.setTrans_date(LocalDate.parse(trans_date));
        transaction.setAmount(Double.parseDouble(amount));
        transaction.setTotal(Double.parseDouble(total));
        transaction.setPending_flag(Boolean.parseBoolean(pending_flag));

        transactionDao.addTransaction(transaction);
        return "redirect:/transactions";
    }
}

package com.sg.bankingapi.controllers;

import com.sg.bankingapi.daos.AccountDao;
import com.sg.bankingapi.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final String ACCOUNTS = "accounts";
    AccountDao accountDao;


    @Autowired
    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @GetMapping(ACCOUNTS)
    public String displayAccounts(Model model) {
        List<Account> accounts = accountDao.getAllAccounts();
        model.addAttribute("accounts", accounts);
        return ACCOUNTS;
    }

}

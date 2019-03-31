package com.app.controller;

import com.app.model.Account;
import com.app.model.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AccountDao accountDao;

    @Autowired
    public UserController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @GetMapping("/all")
    public List<Account> getAllUsers() {
        return accountDao.findAll();
    }

    @GetMapping("/{id}")
    public Account getUserById(@PathVariable Long id) {
        return accountDao.findById(id).orElseThrow(NullPointerException::new);
    }
}

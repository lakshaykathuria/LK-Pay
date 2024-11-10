package org.gfgpay.useraccounts.controller;

import lombok.extern.slf4j.Slf4j;
import org.gfgpay.common.exceptions.NotFoundException;
import org.gfgpay.useraccounts.model.Account;
import org.gfgpay.useraccounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/get_info/{userId}")
    public ResponseEntity<Account> getAccountInfoByUser(@PathVariable UUID userId){
        try{
            Account account = this.accountService.getAccountByUser(userId);
            return ResponseEntity.ok(account);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get_info/{accountId}")
    public ResponseEntity<Account> getAccountInfoById(@PathVariable UUID accountId){
        try{
            Account account = this.accountService.getAccountById(accountId);
            return ResponseEntity.ok(account);
        } catch (NotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}

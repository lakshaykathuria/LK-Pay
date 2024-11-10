package org.gfgpay.useraccounts.service;

import lombok.extern.slf4j.Slf4j;
import org.gfgpay.common.exceptions.NotFoundException;
import org.gfgpay.useraccounts.model.Account;
import org.gfgpay.useraccounts.model.User;
import org.gfgpay.useraccounts.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private Account addAccount(User user){
        Account account = Account.builder()
                .user(user)
                .build();
        account = this.accountRepository.save(account);
        log.info("Account with ID: {} for user with ID: {} was successfully created.",
                account.getAccountId(), account.getUser().getUserId());
        return account;
    }

    public Account getAccountById(UUID accountId){
        Optional<Account> accountOptional = this.accountRepository.findById(accountId);
        return accountOptional.orElseThrow(()->{
           throw new NotFoundException(Account.class, "accountId" , accountId);
        });
    }

    public Account getAccountByUser(User user){
        return this.getAccountByUser(user.getUserId());
    }

    public Account getAccountByUser(UUID userId){
        Optional<Account> accountOptional = this.accountRepository.findByUserId(userId);
        return accountOptional.orElseThrow(()-> new NotFoundException(Account.class, "userId", userId));
    }
}

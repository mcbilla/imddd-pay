package com.mcb.imddd.pay.domain.service.impl;

import com.mcb.imddd.pay.domain.model.aggregate.AccountAggre;
import com.mcb.imddd.pay.domain.model.entity.Account;
import com.mcb.imddd.pay.domain.service.AccountService;
import com.mcb.imddd.pay.infrastructure.client.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountClient accountClient;

    @Override
    public AccountAggre findByAccountNo(String accountNo) {
        Account account = accountClient.findByAccountNo(accountNo);
        return new AccountAggre(account.getId(), account);
    }

    @Override
    public AccountAggre findById(Long id) {
        Account account = accountClient.findById(id);
        return new AccountAggre(account.getId(), account);
    }
}

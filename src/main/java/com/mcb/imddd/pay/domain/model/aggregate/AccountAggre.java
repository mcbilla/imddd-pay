package com.mcb.imddd.pay.domain.model.aggregate;

import com.mcb.imddd.pay.domain.model.entity.Account;

public class AccountAggre {

    private Long id;

    private Account account;

    public AccountAggre(Long id, Account account) {
        this.id = id;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}

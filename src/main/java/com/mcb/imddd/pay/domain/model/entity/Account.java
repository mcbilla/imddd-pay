package com.mcb.imddd.pay.domain.model.entity;

import com.mcb.imddd.pay.domain.base.Entity;

import java.math.BigDecimal;

public class Account implements Entity<Account> {

    private Long id;

    private String accountNo;

    private BigDecimal balance;

    @Override
    public boolean sameIdentityAs(Account other) {
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public static final class Builder {

        private Long id;
        private String accountNo;
        private BigDecimal balance;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder accountNo(String accountNo) {
            this.accountNo = accountNo;
            return this;
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.id = this.id;
            account.balance = this.balance;
            account.accountNo = this.accountNo;
            return account;
        }
    }
}

package com.mcb.imddd.pay.domain.service;

import com.mcb.imddd.pay.domain.model.aggregate.AccountAggre;

public interface AccountService {

    AccountAggre findByAccountNo(String accountNo);

    AccountAggre findById(Long id);
}

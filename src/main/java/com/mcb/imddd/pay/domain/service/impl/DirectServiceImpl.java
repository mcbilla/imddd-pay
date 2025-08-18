package com.mcb.imddd.pay.domain.service.impl;

import com.mcb.imddd.pay.domain.model.aggregate.AccountAggre;
import com.mcb.imddd.pay.domain.model.aggregate.DirectAggre;
import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;
import com.mcb.imddd.pay.domain.service.AccountService;
import com.mcb.imddd.pay.domain.service.DirectService;
import com.mcb.imddd.pay.domain.service.PaymentService;
import com.mcb.imddd.pay.infrastructure.client.DirectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectServiceImpl implements DirectService {

    @Autowired
    private DirectClient directClient;

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Override
    public void sendToBank(DirectAggre directAggre) {
        AccountAggre payAccountAggre = accountService.findById(directAggre.getPayAccountId());
        AccountAggre revAccountAggre = accountService.findById(directAggre.getRevAccountId());
        PaymentAggre paymentAggre = paymentService.findById(directAggre.getPayId());
        directClient.sendToBank(payAccountAggre.getAccount().getAccountNo(),
                revAccountAggre.getAccount().getAccountNo(),
                paymentAggre.getPayment().getPayNo(),
                paymentAggre.getPayment().getAmount().getAmount());
    }
}

package com.mcb.imddd.pay.domain.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mcb.imddd.pay.domain.event.DomainEventPublisher;
import com.mcb.imddd.pay.domain.event.PaymentDirectCallbackEvent;
import com.mcb.imddd.pay.domain.message.IMessageProducer;
import com.mcb.imddd.pay.domain.model.aggregate.AccountAggre;
import com.mcb.imddd.pay.domain.model.aggregate.DirectAggre;
import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;
import com.mcb.imddd.pay.domain.service.AccountService;
import com.mcb.imddd.pay.domain.service.DirectService;
import com.mcb.imddd.pay.domain.service.PaymentService;
import com.mcb.imddd.pay.infrastructure.util.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DirectServiceImpl implements DirectService {

    @Autowired
    private AccountService accountService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private IMessageProducer<Object> messageProducer;

    @Autowired
    private DomainEventPublisher<PaymentDirectCallbackEvent> domainEventPublisher;

    @Override
    public void sendToBank(DirectAggre directAggre) {
        AccountAggre payAccountAggre = accountService.findById(directAggre.getPayAccountId());
        AccountAggre revAccountAggre = accountService.findById(directAggre.getRevAccountId());
        PaymentAggre paymentAggre = paymentService.findById(directAggre.getPayId());

        Map<String, Object> map = new HashMap<>();
        map.put("payAccountNo", payAccountAggre.getAccount().getAccountNo());
        map.put("revAccountNo", revAccountAggre.getAccount().getAccountNo());
        map.put("payNo", paymentAggre.getPayment().getPayNo());
        map.put("amount", paymentAggre.getPayment().getAmount().getAmount());
        messageProducer.send("direct-send", map);
    }

    @Override
    public void handleBankCallback(String message) {
        try {
            PaymentDirectCallbackEvent event = JacksonUtils.getInstance().readValue(message, PaymentDirectCallbackEvent.class);
            domainEventPublisher.publish(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

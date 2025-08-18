package com.mcb.imddd.pay.domain.event;

import com.mcb.imddd.pay.domain.base.DomainEvent;
import com.mcb.imddd.pay.domain.base.DomainEventHandler;
import com.mcb.imddd.pay.domain.model.aggregate.DirectAggre;
import com.mcb.imddd.pay.domain.model.aggregate.PaymentAggre;
import com.mcb.imddd.pay.domain.service.DirectService;
import com.mcb.imddd.pay.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectHandler implements DomainEventHandler<DomainEvent> {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DirectService directService;

    @Override
    public boolean canHandle(DomainEvent event) {
        return event instanceof PaymentCreateEvent;
    }

    @Override
    public void handle(DomainEvent event) {
        PaymentCreateEvent createEvent = (PaymentCreateEvent) event;
        PaymentAggre paymentAggre = paymentService.findById(createEvent.getPaymentAggreId());
        DirectAggre directAggre = new DirectAggre(paymentAggre.getPayAccountId(), paymentAggre.getRevAccountId(), paymentAggre.getId(), paymentAggre.getPayment().getAmount().getAmount());
        directService.sendToBank(directAggre);
    }
}

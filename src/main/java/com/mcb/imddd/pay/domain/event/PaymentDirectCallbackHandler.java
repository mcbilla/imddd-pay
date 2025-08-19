package com.mcb.imddd.pay.domain.event;

import com.mcb.imddd.pay.domain.base.DomainEvent;
import org.springframework.stereotype.Component;

@Component
public class PaymentDirectCallbackHandler implements DomainEventHandler<DomainEvent>{
    @Override
    public boolean canHandle(DomainEvent event) {
        return event instanceof PaymentDirectCallbackEvent;
    }

    @Override
    public void handle(DomainEvent event) {

    }
}

package com.mcb.imddd.pay.domain.event;

import com.mcb.imddd.pay.domain.base.DomainEvent;
import com.mcb.imddd.pay.domain.model.valueobject.PaymentPhrase;

public class PaymentCreateEvent implements DomainEvent {

    private PaymentPhrase paymentEvent;

    private Long paymentAggreId;

    public PaymentCreateEvent(Long paymentAggreId) {
        this.paymentEvent = PaymentPhrase.APPLY_SUBMIT;
        this.paymentAggreId = paymentAggreId;
    }

    public PaymentPhrase getPaymentEvent() {
        return paymentEvent;
    }

    public void setPaymentEvent(PaymentPhrase paymentEvent) {
        this.paymentEvent = paymentEvent;
    }

    public Long getPaymentAggreId() {
        return paymentAggreId;
    }

    public void setPaymentAggreId(Long paymentAggreId) {
        this.paymentAggreId = paymentAggreId;
    }
}

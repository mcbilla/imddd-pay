package com.mcb.imddd.pay.domain.model.aggregate;

import com.mcb.imddd.pay.domain.base.Aggregate;
import com.mcb.imddd.pay.domain.model.entity.Payment;
import com.mcb.imddd.pay.domain.model.valueobject.Amount;
import com.mcb.imddd.pay.domain.repository.PaymentRepository;
import com.mcb.imddd.pay.infrastructure.persistence.entity.PaymentPO;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

public class PaymentAggre implements Aggregate<PaymentAggre> {

    private Long id;

    private Long payAccountId;

    private Long revAccountId;

    private Payment payment;

    @Autowired
    private PaymentRepository paymentRepository;

    public PaymentAggre(Long id, Long payAccountId, Long revAccountId, Payment payment) {
        this.id = id;
        this.payAccountId = payAccountId;
        this.revAccountId = revAccountId;
        this.payment = payment;
    }

    public PaymentAggre(Long payAccountId, Long revAccountId, BigDecimal amount) {
        this.payAccountId = payAccountId;
        this.revAccountId = revAccountId;
        this.payment = Payment.Builder.builder().amount(new Amount(amount)).build();
    }

    public void save() {
        paymentRepository.create(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPayAccountId() {
        return payAccountId;
    }

    public void setPayAccountId(Long payAccountId) {
        this.payAccountId = payAccountId;
    }

    public Long getRevAccountId() {
        return revAccountId;
    }

    public void setRevAccountId(Long revAccountId) {
        this.revAccountId = revAccountId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    @Override
    public boolean sameIdentityAs(PaymentAggre other) {
        return false;
    }
}
